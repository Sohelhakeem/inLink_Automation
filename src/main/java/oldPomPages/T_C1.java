package oldPomPages;

import org.testng.annotations.Test;

import genericLib.BaseClass;

public class T_C1 extends BaseClass{
	
	@Test
	public void tc1() {
SkillraryLoginPage s=new SkillraryLoginPage(driver);
s.gerasbutton();
s.skillrraydemoApplication();

SkillraryDemoApplication d=new SkillraryDemoApplication(driver);
driverutilies.switchTabs(driver);
driverutilies.mouseHover(driver,d.getCousetab());
d.seleniumtrainingtab();

Addtocart a=new Addtocart(driver);
driverutilies.doubleClick(driver,a.getAddbtn());
a.addtocartbutton();
driverutilies.alertPopup(driver);

	}
	
}
