package com.nkxgen.spring.orm.service;

import com.nkxgen.spring.orm.model.Subtask;
import com.nkxgen.spring.orm.model.SubtaskInput;

public interface SubtaskService {

	public void saveSubtask(Subtask subtask);

	public void setNewSubTask(SubtaskInput subtaskInput);
}
