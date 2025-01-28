package com.example.hibernatetwo.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernatetwo.dao.StudentDepartmentDao;
import com.example.hibernatetwo.model.StudentDepartment;
import com.example.hibernatetwo.utils.commonFunctions;

@Repository
public class StudentDepartmentDaoImpl implements StudentDepartmentDao {

	private commonFunctions commonFunctions;
	@Autowired
	public void setcommonFunctions(commonFunctions commonFunctns) {
		this.commonFunctions=commonFunctns;
	}
	
	@Override
	public String saveDepartmentDetailsDao(StudentDepartment department) {
		Session session = commonFunctions.createSession();
		Transaction transaction= session.beginTransaction();
		try {
		String sql="insert into department_details(departmentName, departmentCode) values(:departmentName, :departmentCode)";
		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("departmentName", department.getDepartmentName());
		query.setParameter("departmentCode", department.getDepartmentCode());
		int rowsUpdated=query.executeUpdate();
		transaction.commit();
		session.close();
		return department.getDepartmentCode()+" -Department inserted into db successfully!";
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return "Departments insertion Failed!";
		}
	}

	@Override
	public List<StudentDepartment> getDepartmentList() {
		
		Session session = commonFunctions.createSession();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "select * from department_details order by departmentId asc";
			NativeQuery query = session.createNativeQuery(sql);
			List<StudentDepartment> list = query.getResultList();
			transaction.commit();
			session.close();
			return list;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String saveAllDepartments(List<StudentDepartment> studentDepartments) {
		Session session = commonFunctions.createSession();
		Transaction transaction = session.beginTransaction();
		try {
			
			String sql = "insert into department_details(departmentCode,departmentName) values(:departmentCode, :departmentName)";		
			NativeQuery query= session.createNativeQuery(sql);
			
			for(StudentDepartment s:studentDepartments) {
				query.setParameter("departmentCode", s.getDepartmentCode());
				query.setParameter("departmentName", s.getDepartmentName());
				query.executeUpdate();
			}
			transaction.commit();
			session.close();
			return studentDepartments.size()+"-Departments inserted successfully!";
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return "Departments insertion failed!";
		}
	}

	
}
