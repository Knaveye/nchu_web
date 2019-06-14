package webadv.s16203122.example.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webadv.s16203122.example.entity.Teacher;
import webadv.s16203122.example.repository.TeacherRepository;
import webadv.s16203122.example.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService{
	
	@Autowired
	private TeacherRepository tr;
	
	@Override
	public List<Teacher> listTeacher() {
		
		return tr.findAll();
	}

}
