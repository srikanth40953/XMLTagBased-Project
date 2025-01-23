package com.example.hibernatetwo.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

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
/*
	@Override
	public String saveStudentDetailsDao(Student student) {
		System.out.println("Inside saveStudentDetailsDaoImpl");
		try {
			
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		System.out.println("loading sessionFactory Bean is completed!");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String sql="Insert into student_details (studentName, attendancePercentage) values (:studentName, :attendancePercentage)";							
		NativeQuery<?> query = session.createNativeQuery(sql);
		query.setParameter("studentName", student.getStudentName());
		query.setParameter("attendancePercentage", student.getAttendancePercentage());
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
*/
	
	
	
	@Override
	public String saveStudentDetailsDao(Student student) {
		System.out.println("Inside saveStudentDetailsDaoImpl");
		try {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session=factory.openSession();
		
		session.beginTransaction();
		String sql="Insert into student_details (studentName, attendancePercentage) values (:studentName, :attendancePercentage)";							
		NativeQuery<?> query = session.createNativeQuery(sql);
		query.setParameter("studentName", student.getStudentName());
		query.setParameter("attendancePercentage", student.getAttendancePercentage());
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
	public String updateStudentAttendance(float attendance, String name) {
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

	
	
}
