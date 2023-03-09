package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class employeesPage {
	
	@FindBy(xpath="//span[normalize-space()='Employees']")
	private WebElement employees;
	
	@FindBy(xpath="//button[normalize-space()='Active']")
	private WebElement active;
	
	@FindBy(xpath="//input[@placeholder='Search Active Employee']")
	private WebElement activeSearchField;
	
			@FindBy(xpath = "(//div[contains(@class,'flexMinWidthCol pdngHXS')])[1]")
			private WebElement employeeProfile;
					@FindBy(xpath = "//button[@aria-label='Edit']")
					private WebElement editicon;
							@FindBy(xpath = "(//div[contains(@role,'button')])[1]")
							private WebElement department;
							@FindBy(xpath = "(//div[contains(@role,'button')])[2]")
							private WebElement designation;
							@FindBy(xpath = "//button[normalize-space()='Cancel']")
							private WebElement cancel;
							@FindBy(xpath = "//button[normalize-space()='Save']")
							private WebElement save;
			@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/span[1]/div[1]/span[1]")
			private WebElement roleEmployee;
			@FindBy(xpath="(//li[@role='menuitem'])[1]")
			private WebElement admin;
						@FindBy(xpath="//button[normalize-space()='Grant Team Admin']")
						public WebElement grantAdmin;
			@FindBy(xpath="(//span[@id='status'])[2]")
			private WebElement roleAdmin;
					@FindBy(xpath="//li[@role='menuitem']")
					private WebElement employeesrole;
					@FindBy(xpath="//button[normalize-space()='Remove from Admin']")
					public WebElement removeAdmin;
			@FindBy(xpath = "//button[normalize-space()='News Feed']")
			private WebElement newsFeed;
					@FindBy(xpath = "(//*[name()='svg'][@aria-label='Back'])[1]")
					private WebElement backbtn;
					
	@FindBy(xpath="//button[normalize-space()='Pending(1)']")
	private WebElement pending;
		@FindBy(xpath="//input[@type='search']")
		private WebElement pendingsearch;
			@FindBy(xpath="//span[@id='status']")
			private WebElement pendingStatus;
			@FindBy(xpath="(//li[@role='menuitem'])[1]")
			private WebElement Pendingapprove;
					@FindBy(xpath="//body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
					private WebElement Pdepartment;
					@FindBy(xpath="//body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")
					private WebElement Pdevision;
					@FindBy(xpath="(//div[@role='button'])[4]")
					private WebElement Pdesignation;
					@FindBy(xpath="(//input[@type='text'])[3]")
					private WebElement workLocation;
					@FindBy(xpath="//button[normalize-space()='Approve']")
					private WebElement approve;
					@FindBy(xpath="//button[normalize-space()='Cancel']")
					private WebElement pendingcancel;
			@FindBy(xpath="//div[@id='fade-menu']//li[2]")
			private WebElement Pendingreject;
					@FindBy(xpath="//button[normalize-space()='Reject']")
					private WebElement pConfreject;
					@FindBy(xpath="//button[normalize-space()='Cancel']")
					private WebElement Pendingcancel;
					
	@FindBy(xpath="//button[normalize-space()='Rejected']")
	private WebElement rejected;
	
	@FindBy(xpath="//div[@class='flexAutoRow pointer webSearch']//button[@type='button'][normalize-space()='Invite']")
	private WebElement invite;
	
	@FindBy(xpath="//button[normalize-space()='New']")
	private WebElement newBtn;;
	
	@FindBy(xpath="//div[@class='flexAutoRow pointer pdngRSM']//button[@type='button']")
	private WebElement sortByfilter;
	
		@FindBy(xpath="(//li[@role='menuitem'])[2]")
		private WebElement sortemployees;
		@FindBy(xpath="(//li[@role='menuitem'])[3]")
		private WebElement sortadmins;
		@FindBy(xpath="(//li[@role='menuitem'])[4]")
		private WebElement sortrelationManagers;
	
	@FindBy(xpath="//div[@class='flexAutoRow']//div[@class='flexCol']//button[@type='button']")
	private WebElement departmentfilter;
			@FindBy(xpath="(//input[@type='checkbox'])[1]")
			private WebElement allCheckbox;
			@FindBy(xpath="//button[normalize-space()='Apply']")
			private WebElement deptFilterapplyBtn;
			
			
	public employeesPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void Employees() {
		employees.click();
	}
	public void Active() {
		employees.click();
	}
	public void ActiveSearchField(String name) {
		activeSearchField.sendKeys(name);
	}
	public void EmployeeProfile() {
		employeeProfile.click();
	}
				public void Editicon() {
					editicon.click();
				}
						public void EditDepartment() {
							department.click();
						}
						public void EditDesignation() {
							designation.click();
						}
						public void WorkLocation(String name) {
							workLocation.sendKeys(name);
						}
						public void Cancel() {
							cancel.click();
						}
						public void EditSave() {
							save.click();
						}
				public void RoleEmployee() {
					roleEmployee.click();
				}
				public void Admin() {
					admin.click();
				}
				public void GrantAdmin() {
					grantAdmin.click();
				}
				public void RoleAdmin() {
					roleAdmin.click();
				}
				public void EmployeesRole() {
					employeesrole.click();
				}
				public void RemoveAdmin() {
					removeAdmin.click();
				}
				public void NewsFeed() {
					newsFeed.click();
				}
				public void Backbtn() {
					backbtn.click();
				}
	public void Pending() {
		pending.click();
	}
			public void PendingSearch(String name) {
				pendingsearch.sendKeys(name);
			}
			public void PendingStatus() {
				pendingStatus.click();
			}
			public void PendingApprove() {
				Pendingapprove.click();
			}
					public void Pendingdepartment() {
						Pdepartment.click();
					}
					public void Pendingdevision() {
						Pdevision.click();
					}
					public void Pendingdesignation() {
						Pdesignation.click();
					}
					public void WorkLocation() {
						workLocation.click();
					}
					public void PFinalApprove() {
						approve.click();
					}
					public void PFinalApproveDisplayed() {
						approve.isDisplayed();
					}
					public void pendingCancel() {
						pendingcancel.click();
					}
		public void PendingReject() {
			Pendingreject.click();
		}
			public void PendingConfreject() {
				pConfreject.click();
			}
			public void PendingConfrejectDisplay() {
				pConfreject.isDisplayed();
			}
			public void PendingCancel() {
				Pendingcancel.click();
			}

	public void Rejected() {
		rejected.click();
	}
	public void Invite() {
		invite.click();
	}
	public void NewBtn() {
		newBtn.click();
	}
	public void SortByfilter() {
		sortByfilter.click();
	}
			public void Sortemployees() {
				sortemployees.click();
			}
			public void Sortadmins() {
				sortadmins.click();
			}
			public void SortrelationManagers() {
				sortrelationManagers.click();
			}
	public void Departmentfilter() {
		departmentfilter.click();
	}
			public void AllCheckbox() {
				allCheckbox.click();
			}
			public void DeptFilterapplyBtn() {
				deptFilterapplyBtn.click();
			}
			
}
