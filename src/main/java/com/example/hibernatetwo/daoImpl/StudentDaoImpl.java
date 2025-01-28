package com.example.hibernatetwo.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.example.hibernatetwo.dao.StudentDao;
import com.example.hibernatetwo.model.Student;
import com.example.hibernatetwo.service.StudentService;
import com.example.hibernatetwo.serviceImpl.StudentServiceImpl;
import com.example.hibernatetwo.utils.commonFunctions;

@Repository
public class StudentDaoImpl implements StudentDao{

	/* (wrong way- application is restarting multiple times)
	 * private ApplicationContext context; private SessionFactory sessionFactory;
	 * private Session session; public StudentDaoImpl() { this.context = new
	 * ClassPathXmlApplicationContext("applicationContext.xml"); this.sessionFactory
	 * = context.getBean(SessionFactory.class); this.session =
	 * sessionFactory.openSession(); }
	 */
	
	/* (getting LocalSessionFactoryBean not found issue again)
	 * @Autowired private ApplicationContext context;
	 * 
	 * @Autowired private LocalSessionFactoryBean sessionFactoryBean;
	 * 
	 * private HibernateTemplate hibernateTemplate;
	 * 
	 * @PostConstruct public void init() { this.hibernateTemplate = new
	 * HibernateTemplate(sessionFactoryBean.getObject()); }
	 */
	
	@Override
	public String testStudentDao() {
		System.out.println("inside testStudentDaoImpl");
		String success="StudentDaoImpl success! ";
		return success;
	}	
	
	@Override
	public String saveStudentDetailsDao(Student student) {
		System.out.println("Inside saveStudentDetailsDaoImpl");
		try {
		
		Session session = cFunctions.createSession();
		
		session.beginTransaction();
		String sql="Insert into student_details (studentName, attendancePercentage, departmentId) values (:studentName, :attendancePercentage, :departmentId)";							
		NativeQuery<?> query = session.createNativeQuery(sql);
		query.setParameter("studentName", student.getStudentName());
		query.setParameter("attendancePercentage", student.getAttendancePercentage());
		query.setParameter("departmentId", student.getDepartmentId());
		int rowsUpdated = query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		if(rowsUpdated>0) {
			return "Student inserted successfully!";
		} else {
			return "Student insertion Failed!";
		}
		} catch(Exception e) {
			System.out.println("message="+e.getMessage());
			return "Student insertion Failed!";
		}
	}

	@Autowired
	private commonFunctions cFunctions;

	@Override
	public String updateStudentAttendance(BigDecimal attendance, String name) {
		try {
		Session session = cFunctions.createSession();
		session.beginTransaction();
		
		String sql="update student_details set attendancePercentage =:attendancePercentage where studentName=:studentName";
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("attendancePercentage", attendance);
		query.setParameter("studentName",name);
		int rowsUpdated= query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		if(rowsUpdated>0) {
			return "Student update successfully!";
		} else {
			return "Student update Failed!";
		}
		} catch(Exception e) {
			System.out.println("message="+e.getMessage());
			return "Student update Failed!";
		}
	}



	@Override
	public List<Student> getStudentsList() {
		
		Session session = cFunctions.createSession();
		session.beginTransaction();
		String sql="select * from student_details";
		NativeQuery<Student> query = session.createNativeQuery(sql);
		List<Student> studentList = new ArrayList<Student>();
		studentList= query.getResultList();
		session.getTransaction().commit();
		session.close();
		return studentList;
	}

	@Override
	public String saveAllStudents(List<Student> students) {
		Session session = cFunctions.createSession();
		Transaction transaction = session.beginTransaction();
		try {
		for(Student stu : students) {
			session.persist(stu);
		}
		transaction.commit();
		return students.size()+" students inserted successfully!";
		} catch (Exception e) {
			if(transaction !=null)
				transaction.rollback();
			e.printStackTrace();
			return "students insertion failed!";
		}
	}

	@Override
	public List<Map<String,String>> getAllStudentsAccToDepartment() {
		Session session = cFunctions.createSession();
		Transaction transaction = session.beginTransaction(); 
		try {
			String sql = "select rollNum,studentName,departmentCode,departmentName,attendancePercentage,"
						+ "dpd_d.departmentId from student_details as std_d left join department_details as dpd_d on "
						+ "std_d.departmentId = dpd_d.departmentId";
			NativeQuery query=session.createNativeQuery(sql);
			List<Object[]> result = query.getResultList(); // here we will get data in this form- i.e; only values
		/*	(eg. [[1,"Srikanth1","ECE","Electronics and communication Engineering",90.00,1],[2,"Srikanth2","IT","Information Technology Engineering",80.00,2]];	*/
			
			List<Map<String,String>> listOfMap = new ArrayList<>();
			
			for(Object[] s:result) {
				Map<String, String> map = new HashMap<>();
				map.put("rollNum", String.valueOf(s[0]));
				map.put("studentName", String.valueOf(s[1]));
				map.put("departmentCode", String.valueOf(s[2]));
				map.put("departmentName", String.valueOf(s[3]));
				map.put("attendancePercentage", String.valueOf(s[4]));
				listOfMap.add(map);
				
			}
			
			transaction.commit();
			session.close();
			return listOfMap;
		} catch(Exception e) {
			transaction.rollback();
			return null;
		}
	}

	
	
}
