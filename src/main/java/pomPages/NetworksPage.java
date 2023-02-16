package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetworksPage {

	@FindBy(xpath="(//div[@class='resNavLink '])[2]")
	private WebElement networks;
	
	@FindBy( xpath="//input[@type='search']")
	private WebElement searchFieldNetwork;
	
	@FindBy( xpath="//div[@class='flexInline iconBox alignCntr iconBoxSM']//*[name()='svg']")
	private WebElement threedots;
					@FindBy( xpath="//li[@value='myProfile']")
					private WebElement recommendedIndustries;
					@FindBy( xpath="//li[@value='settings']")
					private WebElement inviteBusiness;

	@FindBy( xpath="//button[normalize-space()='MY NETWORKS']")
	private WebElement myNetworks;
	
	@FindBy( xpath="(//button[@role='tab'])[2]")
	private WebElement pending;
			@FindBy( xpath="//button[normalize-space()='Reject']")
			private WebElement reject;
			@FindBy( xpath="//button[normalize-space()='Approve']")
			private WebElement approve;
				@FindBy( xpath="//button[normalize-space()='Accept']")
				private WebElement acceptapprove;
				@FindBy( xpath="//button[normalize-space()='Cancel']")
				private WebElement cancelapprove;
				
	
	@FindBy( xpath="(//button[@role='tab'])[3]")
	private WebElement follow;
	
	@FindBy( xpath="(//button[@role='tab'])[4]")
	private WebElement blockList;
	
	@FindBy( xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation css-1xio2w5']")
	private WebElement relationsFilter;
	
					@FindBy( xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[5]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]/input[1]")
					private WebElement all;
					
					@FindBy( xpath="//input[@value='Competitors of']")
					private WebElement compititorsOf;
					
					@FindBy( xpath="//input[@value='Industrial Relationship of']")
					private WebElement industrialRelationship;
					
					@FindBy( xpath="//input[@value='Manufacturer']")
					private WebElement manufacturer;
					
					@FindBy( xpath="//input[@value='partner of']")
					private WebElement partnerOf;
					
					@FindBy( xpath="//input[@value='share holder']")
					private WebElement shareholder;
					
					@FindBy( xpath="//input[@value='share holder of']")
					private WebElement shareholderOf;
	
					@FindBy( xpath="//button[normalize-space()='Apply']")
					private WebElement applyButton;
					
					@FindBy( xpath="//div[@class='flexAutoRow alignCntr pointer pdngRSM']//*[name()='svg']")
					private WebElement cancel;
					
	@FindBy(xpath ="//div[@class='flexCol fullHeight']//div[1]//div[1]//div[1]//div[2]//div[1]//button[1]")
	private WebElement connectBtn;
	
	@FindBy(xpath ="//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]")
	private WebElement followBtn;
	
	@FindBy(xpath="//textarea[@placeholder='Please write a short note why you want to reject this Connection.']")
	private WebElement rejectreasonField;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	private WebElement Rcancel;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-191um2i'][normalize-space()='Reject']")
	private WebElement Rreject;
	
	public NetworksPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Networks () {
		networks.click();
	}
	public void SearchFieldNetwork (String name) {
		searchFieldNetwork.sendKeys(name);
	}
					public void RecommendedIndustries () {
						recommendedIndustries.click();
					}
					public void InviteBusiness () {
						inviteBusiness.click();
					}
	public void MyNetworks () {
		myNetworks.click();
	}
	public void Pending () {
		pending.click();
	}
	public void Follow () {
		follow.click();
	}
	public void BlockList () {
		blockList.click();
	}
	public void RelationsFilter () {
		relationsFilter.click();
	}
					public void All () {
						all.click();
					}
					public void CompititorsOf () {
						compititorsOf.click();
					}
					public void IndustrialRelationship () {
						industrialRelationship.click();
					}
					public void Manufacturer () {
						manufacturer.click();
					}
					public void PartnerOf () {
						partnerOf.click();
					}
					public void Shareholder() {
						shareholder.click();
					}
					public void ShareholderOf () {
						all.click();
					}
					public void ApplyButton () {
						applyButton.click();
					}
					public void Cancel () {
						cancel.click();
					}
	public void ConnectButton () {
		connectBtn.click();
	}
	public void FollowButton () {
		followBtn.click();
	}
	public void Reject () {
		reject.click();
	}
	public void Approve () {
		approve.click();
	}
			public void AcceptApprove () {
				acceptapprove.click();
			}
			public void CancelApprove () {
				cancelapprove.click();
			}
	public void RejectReasonField (String name) {
		rejectreasonField.sendKeys(name);
	}
	public void Rejectcancel () {
		Rcancel.click();
	}
	public void RReject () {
		Rreject.click();
	}
}
