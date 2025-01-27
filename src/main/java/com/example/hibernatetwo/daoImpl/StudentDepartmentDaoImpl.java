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
	public String updateDepartmentName(int studDepartmentId, String studDepartmentName) {
		Session session = commonFunctions.createSession();
		Transaction transaction= session.beginTransaction();
		try{
			
		} catch (Exception e) {
			
		}
		
		
		
		return null;
	}

	@Override
	public List<StudentDepartment> getDepartmentList() {
		
		return null;
	}

	@Override
	public String saveAllDepartments(List<StudentDepartment> studentDepartments) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
