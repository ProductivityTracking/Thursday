package com.nkxgen.spring.orm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.SubtaskDao;
import com.nkxgen.spring.orm.model.Subtask;
import com.nkxgen.spring.orm.model.SubtaskInput;

@Service
@Transactional
public class SubtaskServiceImpl implements SubtaskService {

	@Autowired
	private SubtaskDao subtaskDao;

	public void saveSubtask(Subtask subtask) {
		subtaskDao.saveSubtask(subtask);
	}

	@Override
	public void setNewSubTask(SubtaskInput subtaskInput) {
		Subtask subtask = subtaskInput.toEntity();
		subtaskDao.setNewSubTask(subtask);

	}
}
