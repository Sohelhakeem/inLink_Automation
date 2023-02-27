package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
@FindBy(xpath="//span[@aria-label='Notifications']")
private WebElement notification;
	
@FindBy(xpath="//input[@type='search']")
private WebElement searchfield;
		
@FindBy(xpath="(//*[name()='svg'][contains(@class,'MuiSvgIcon-root MuiSvgIcon-fontSizeMedium pointer css-vubbuv')])[3]")
private WebElement Threedotsfilterbutton;
@FindBy(xpath="(//li[@role='menuitem'])[1]")
private WebElement filterbutton;
		@FindBy(xpath="(//li[normalize-space()='Archived'])[1]")
		private WebElement archivedCheckbox;
		
		@FindBy(xpath="(//input[@type='checkbox'])[1]")
		private WebElement allCheckbox;
		@FindBy(xpath="(//input[@type='checkbox'])[2]")
		private WebElement selfPostCheckbox;
		@FindBy(xpath="(//input[@type='checkbox'])[3]")
		private WebElement compitators;
		@FindBy(xpath="(//input[@type='checkbox'])[4]")
		private WebElement industrialRelationship;
		@FindBy(xpath="(//input[@type='checkbox'])[6]")
		private WebElement manufacturer;
		@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[4]/div[2]/span[1]/input[1]")
		private WebElement partnerCheckbox;
		@FindBy(xpath="(//input[@type='checkbox'])[6]")
		private WebElement shareHolderCheckbox;
		@FindBy(xpath="//button[normalize-space()='Apply']")
		private WebElement applyBtn;
		
@FindBy(xpath="//span[@class='pdngXS brdrBlackSM postWidth brdrRadiusXSM pointer lightTxt feedHover']")
private WebElement createPost;

@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/*[name()='svg'][1]")
private WebElement threeDots;
	@FindBy(xpath="//li[normalize-space()='Edit']")
	private WebElement editicon;
	@FindBy(xpath="//li[normalize-space()='Delete']")
	private WebElement deleteicon;
			@FindBy(xpath="//input[@name='archive']")
			private WebElement deleteCheckbox;
			@FindBy(xpath="//button[normalize-space()='Delete']")
			private WebElement deleteButton;
			
@FindBy(xpath="//li[normalize-space()='Bookmark']")
private WebElement bookmarkicon;
		
			@FindBy(xpath="//span[@aria-label='Explore Bookmarks']")
			private WebElement exploreBookmark;
			@FindBy(xpath="(//input[@type='search'])[1]")
			private WebElement bookmarkSeaarchField;
			@FindBy(xpath="(//div[@class='flexMinWidthCol pdngSM'])[1]")
			private WebElement seeBookmarkPost;
			@FindBy(xpath="//div[@class=' flexAutoRow flexEnd pointer justifyEnd']//*[name()='svg']")
			private WebElement cancelBookmarkPost;
			@FindBy(xpath="//div[@class='flexCol whiteBg fullHeight scrollY']//div[1]//div[1]//div[3]")
			private WebElement removeBookmarkonPost;
			
			@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]")
			private WebElement bookmarkLike;
			public WebElement getBookmarkLike() {
				return bookmarkLike;
			}

			@FindBy(xpath="(//span[contains(text(),'Comment')])[1]")
			private WebElement bookmarkComment;
			
			public WebElement getBookmarkComment() {
				return bookmarkComment;
			}
			@FindBy(xpath="//textarea[@id='outlined-basic']")
			private WebElement CommentFieldBookmark;
			@FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium blueTxt css-1m44q5']")
			private WebElement sendIcon;
			@FindBy(xpath="//body//div[@id='root']//div[@class='flexCol']//div[@class='flexCol']//div[@class='flexCol']//div[1]//div[1]//div[2]//span[2]//span[1]")
			private WebElement replyComment;
			@FindBy(xpath="//textarea[@id='outlined-adornment-weight']")
			private WebElement replyCommentTxt;
			@FindBy(xpath="//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd MuiInputAdornment-outlined MuiInputAdornment-sizeMedium pointer css-1nvf7g0']//*[name()='svg']")
			private WebElement replyCommentTxtsend;
			

			@FindBy(xpath="(//span[contains(text(),'Share')])[1]")
			private WebElement bookmarkShare;
			
			public WebElement getBookmarkShare() {
				return bookmarkShare;
			}
			@FindBy(xpath="//div[@class='flexInline alignCntr']//*[name()='svg']")
			private WebElement cancelBookmarkPage;

@FindBy(xpath="(//span[contains(text(),'Like')])[1]")
private WebElement Like;
@FindBy(xpath="(//span[contains(text(),'Comment')])[1]")
private WebElement Comment;
@FindBy(xpath="(//span[contains(text(),'Share')])[1]")
private WebElement Share;





@FindBy(xpath="//button[normalize-space()='See More']")
private WebElement loadMore;
public WebElement getLoadMore() {
	return loadMore;
}

public homePage (WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void NotificationIcon() {
	notification.click();
}

public void SearchFeedField(String search) {
	searchfield.sendKeys(search);
	
}

public void Threedotsfilter() {
	Threedotsfilterbutton.click();
}
		public void FilterButton() {
			filterbutton.click();
		}
		      public void ArchivedCheckbox() {
		    	  archivedCheckbox.click();
		      }
		      public void AllCheckbox() {
		    	  allCheckbox.click();
		      }
		      public void SelfPostCheckbox() {
		    	  selfPostCheckbox.click();
		      }
		      public void Compitators() {
		    	  compitators.click();
		      }
		      public void IndustrialRelationship() {
		    	  industrialRelationship.click();
		      }
		      public void Manufacturer() {
		    	  manufacturer.click();
		      }
		      public void PartnerCheckbox() {
		    	  partnerCheckbox.click();
		      }
		      public void ShareHolderCheckbox() {
		    	  shareHolderCheckbox.click();
		      }
		      public void ApplyButton() {
		    	  applyBtn.click();
		      }
public void ThreeDots() {
	threeDots.click();
}
public void EditIcon() {
	editicon.click();
}
public void DeleteIcon() {
	deleteicon.click();
}
		public void DeleteCheckbox() {
			deleteCheckbox.click();
		}
		public void ConfirmDeleteButton() {
			deleteButton.click();
		}
public void BookmarkIcon() {
	bookmarkicon.click();
}
				public void ExploreBookmark() {
					exploreBookmark.click();
				}
				public void BookmarkSeaarchField(String name) {
					bookmarkSeaarchField.sendKeys(name);
				}
				public void SeeBookmarkPost() {
					seeBookmarkPost.click();
				}
				public void BookmarkLikeIcon() {
					bookmarkLike.click();
				}
				public void BookmarkCommentIcon() {
					bookmarkComment.click();
				}
						public void commentFieldBookmark() {
							CommentFieldBookmark.click();
						}
						public void SendIcon() {
							sendIcon.click();
						}
						public void ReplyComment() {
							replyComment.click();
						}
						public void ReplyCommentTxt() {
							replyCommentTxt.click();
						}
						public void ReplyCommentTxtsend() {
							replyCommentTxtsend.click();
						}
				
					
				public void BookmarkShareIcon() {
					bookmarkShare.click();
				}
				public void CancelBookmarkPost() {
					cancelBookmarkPost.click();
				}
				public void RemoveBookmarkonPost() {
					removeBookmarkonPost.click();
				}
				public void CancelBookmarkPage() {
					cancelBookmarkPage.click();
				}
public void CreatePost() {
	createPost.click();
}

public void LoadMoreText() {
	loadMore.click();
}

public void LikeIcon() {
	Like.click();
}
public void CommentIcon() {
	Comment.click();
}
public void ShareIcon() {
	Share.click();
}

}
