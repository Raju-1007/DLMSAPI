package com.dlms.notificationservice.model;

public class QuestionDTO {
	
	private Long questionId;
    private String prompt;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;

    private Long classId;
    private String className;

    private Long assignmentId;

    private Long teacherId;
    private Long subjectId;
    
    public QuestionDTO() {
    	super();
    }

	public QuestionDTO(Long questionId, String prompt, String optionA, String optionB, String optionC, String optionD,
			String correctOption, Long classId, String className, Long assignmentId, Long teacherId, Long subjectId) {
		super();
		this.questionId = questionId;
		this.prompt = prompt;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
		this.classId = classId;
		this.className = className;
		this.assignmentId = assignmentId;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
    

}
