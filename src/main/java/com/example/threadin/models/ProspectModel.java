package com.example.threadin.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.example.threadin.models.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;;


@Entity
@Table(name = "prospects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProspectModel extends AuditModel {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 6246408326928301912L;

	 enum Gender{
		MALE (0), FEMALE (1), OTHER (2);
		
		private int value;
		
		Gender(int value) {
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
		
		public void setValue(int value){
			this.value = value;
		}
	}
	
	 enum Marital{
		MARRIED (0), UNMARRIED (1), DIVORCY (2), OTHER (3);
		
		private int value;
		
		Marital(int value) {
			this.value = value;
		}
		
		public int getValue(){
			return value;
		}
		
		public void setValue(int value){
			this.value = value;
		}
	}
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="Please enter your first name")
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Email
	@Column(name="email_id")
	@NotBlank(message="Please enter an email address")
	private String emailId;
	
	@Column(name="email_visible")
	private boolean isEmailVisible=true;
	
	@Column(name="gender",nullable=false)
	private Gender gender;
	
	@Column(name = "dob",nullable=false)
	@Past
	private Date dob;

	@Column(name = "mobile_no")
	private String[] mobile;
	
	@Column(name = "mobile_visible")
	private boolean isMobileVisible=true;
	
	@Column(name = "marital_status")
	private Marital maritalStatus;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="languages")
	private String[] langCode;
	
	@Column(name="board_10th")
	private String board10th;
	
	@Column(name="school_10th")
	private String school10th;
	
	@Column(name="year_of_passing_10th")
	private Date yearOfPassing10th; 
	
	@Column(name="percentage_10th")
	private String percentage10th;
	
	@Column(name="board_12th")
	private String board12th;
	
	@Column(name="school_12th")
	private String school12th;
	
	@Column(name="year_of_passing_12th")
	@Past
	private Date yearOfPassing12th; 
	
	@Column(name="percentage_12th")
	private String percentage12th;
	
	@NotBlank(message="Please enter your college Name") 
	@Column(name="college_name",nullable=false)
	private String college;
	
	@Column(name="college_id")
	private String collegeId;
	
	@NotBlank(message="please enter your course name")
	@Column(name="course_name",nullable=false)
	private String courseName;
	
	@NotBlank(message="please enter your college centre")
	@Column(name="college_centre",nullable=false)
	private String centre;
	
	@Column(name="college_start_Date")
	@Past
	private Date collegeStartDate;
	
	@Column(name="college_end_Date")
	private Date collegeEndYear;
	
	@Column(name="university")
	private String university;
	
	@Lob
	@Column(name="profile_pic")
	private byte[] pic;
	
	@Lob
	@Column(name="resume")
	private byte[] resume;
	
	@Column(name="career_discription")
	private String careerDiscription;
	
	@Column(name="year_of_work_exp")
	private String yearOfWorkExp;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<AddressModel> addressModel;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<CollegeModel> collegeModel;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<InternshipModel> internshipModel;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<ProjectModel> projectModel;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<WorkDetailsModel> workDetailsModel;

	public ProspectModel() {
		super();
	}

	public ProspectModel(@NotBlank(message = "Please enter your first name") String firstName, String lastName,
			@Email @NotBlank(message = "Please enter an email address") String emailId, boolean isEmailVisible,
			@NotBlank(message = "Please enter your gender") Gender gender,
			@NotBlank(message = "Please enter your DOB") @Past Date dob, String[] mobile, boolean isMobileVisible,
			Marital maritalStatus, String countryCode, String[] langCode, String board10th, String school10th,
			Date yearOfPassing10th, String percentage10th, String board12th, String school12th,
			@Past Date yearOfPassing12th, String percentage12th,
			@NotBlank(message = "Please enter your college Name") String college, String collegeId,
			@NotBlank(message = "please enter your course name") String courseName,
			@NotBlank(message = "please enter your college centre") String centre, @Past Date collegeStartDate,
			Date collegeEndYear, String university, byte[] pic, byte[] resume, String careerDiscription,
			String yearOfWorkExp, Set<AddressModel> addressModel, Set<CollegeModel> collegeModel,
			Set<InternshipModel> internshipModel, Set<ProjectModel> projectModel,
			Set<WorkDetailsModel> workDetailsModel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.isEmailVisible = isEmailVisible;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.isMobileVisible = isMobileVisible;
		this.maritalStatus = maritalStatus;
		this.countryCode = countryCode;
		this.langCode = langCode;
		this.board10th = board10th;
		this.school10th = school10th;
		this.yearOfPassing10th = yearOfPassing10th;
		this.percentage10th = percentage10th;
		this.board12th = board12th;
		this.school12th = school12th;
		this.yearOfPassing12th = yearOfPassing12th;
		this.percentage12th = percentage12th;
		this.college = college;
		this.collegeId = collegeId;
		this.courseName = courseName;
		this.centre = centre;
		this.collegeStartDate = collegeStartDate;
		this.collegeEndYear = collegeEndYear;
		this.university = university;
		this.pic = pic;
		this.resume = resume;
		this.careerDiscription = careerDiscription;
		this.yearOfWorkExp = yearOfWorkExp;
		this.addressModel = addressModel;
		this.collegeModel = collegeModel;
		this.internshipModel = internshipModel;
		this.projectModel = projectModel;
		this.workDetailsModel = workDetailsModel;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getYearOfWorkExp() {
		return yearOfWorkExp;
	}

	public void setYearOfWorkExp(String yearOfWorkExp) {
		this.yearOfWorkExp = yearOfWorkExp;
	}

	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public boolean isEmailVisible() {
		return isEmailVisible;
	}

	public void setEmailVisible(boolean isEmailVisible) {
		this.isEmailVisible = isEmailVisible;
	}

	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Marital getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(Marital maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getBoard10th() {
		return board10th;
	}


	public void setBoard10th(String board10th) {
		this.board10th = board10th;
	}


	public String getSchool10th() {
		return school10th;
	}


	public void setSchool10th(String school10th) {
		this.school10th = school10th;
	}


	public String getPercentage10th() {
		return percentage10th;
	}


	public void setPercentage10th(String percentage10th) {
		this.percentage10th = percentage10th;
	}


	public String getBoard12th() {
		return board12th;
	}


	public void setBoard12th(String board12th) {
		this.board12th = board12th;
	}


	public String getSchool12th() {
		return school12th;
	}


	public void setSchool12th(String school12th) {
		this.school12th = school12th;
	}

	public String getPercentage12th() {
		return percentage12th;
	}


	public void setPercentage12th(String percentage12th) {
		this.percentage12th = percentage12th;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getCollegeId() {
		return collegeId;
	}


	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCentre() {
		return centre;
	}


	public void setCentre(String centre) {
		this.centre = centre;
	}

	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public byte[] getPic() {
		return pic;
	}


	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getCareerDiscription() {
		return careerDiscription;
	}
	
	public void setCareerDiscription(String careerDiscription) {
		this.careerDiscription = careerDiscription;
	}

	public String[] getMobile() {
		return mobile;
	}

	public void setMobile(String[] mobile) {
		this.mobile = mobile;
	}

	public boolean isMobileVisible() {
		return isMobileVisible;
	}

	public void setMobileVisible(boolean isMobileVisible) {
		this.isMobileVisible = isMobileVisible;
	}

	public String[] getLangCode() {
		return langCode;
	}

	public void setLangCode(String[] langCode) {
		this.langCode = langCode;
	}

	public Set<AddressModel> getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(Set<AddressModel> addressModel) {
		this.addressModel = addressModel;
	}

	public Set<CollegeModel> getCollegeModel() {
		return collegeModel;
	}

	public void setCollegeModel(Set<CollegeModel> collegeModel) {
		this.collegeModel = collegeModel;
	}

	public Set<InternshipModel> getInternshipModel() {
		return internshipModel;
	}

	public void setInternshipModel(Set<InternshipModel> internshipModel) {
		this.internshipModel = internshipModel;
	}

	public Set<ProjectModel> getProjectModel() {
		return projectModel;
	}

	public void setProjectModel(Set<ProjectModel> projectModel) {
		this.projectModel = projectModel;
	}

	public Set<WorkDetailsModel> getWorkDetailsModel() {
		return workDetailsModel;
	}

	public void setWorkDetailsModel(Set<WorkDetailsModel> workDetailsModel) {
		this.workDetailsModel = workDetailsModel;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getYearOfPassing10th() {
		return yearOfPassing10th;
	}

	public void setYearOfPassing10th(Date yearOfPassing10th) {
		this.yearOfPassing10th = yearOfPassing10th;
	}

	public Date getYearOfPassing12th() {
		return yearOfPassing12th;
	}

	public void setYearOfPassing12th(Date yearOfPassing12th) {
		this.yearOfPassing12th = yearOfPassing12th;
	}

	public Date getCollegeStartDate() {
		return collegeStartDate;
	}

	public void setCollegeStartDate(Date collegeStartDate) {
		this.collegeStartDate = collegeStartDate;
	}

	public Date getCollegeEndYear() {
		return collegeEndYear;
	}

	public void setCollegeEndYear(Date collegeEndYear) {
		this.collegeEndYear = collegeEndYear;
	}	
	
	
	
}
