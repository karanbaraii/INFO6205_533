package domain;

/**
 * Simple course module abstraction, which defines the Professors teaching the module.
 */
public class Course {
    private final int courseId;
    private final String courseCode;
    private final String course;
    private final int professorIds[];
    
    /**
     * Initialize new Module
     * 
     * @param moduleId
     * @param moduleCode
     * @param module
     * @param professorIds
     */
    public Course(int moduleId, String moduleCode, String module, int professorIds[]){
        this.courseId = moduleId;
        this.courseCode = moduleCode;
        this.course = module;
        this.professorIds = professorIds;
    }
    
    /**
     * Get moduleId
     * 
     * @return moduleId
     */
    public int getModuleId(){
        return this.courseId;
    }
    
    /**
     * Get module code
     * 
     * @return moduleCode
     */
    public String getModuleCode(){
        return this.courseCode;
    }
    
    /**
     * Get module name
     * 
     * @return moduleName
     */
    public String getModuleName(){
        return this.course;
    }
    
    /**
     * Get random professor Id
     * 
     * @return professorId
     */
    public int getRandomProfessorId(){
        int professorId = professorIds[(int) (professorIds.length * Math.random())];
        return professorId;
    }
}
