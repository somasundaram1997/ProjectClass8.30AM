package org.test.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		return driver;

	}
	public static void urlLaunch(String url,int a) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static void sleep(long a) throws InterruptedException {
		Thread.sleep(a);
	}
	public static void quit() {
		driver.quit();
	}
	public static void close() {
		driver.close();
	}
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static void clear(WebElement e) {
		e.clear();
	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static String getAttribute1(WebElement e) {
		String attribute= e.getAttribute("value");
		return attribute;
	}
	public static String getAttribute2(WebElement e) {
		String attribute= e.getAttribute("innerText");
		return attribute;
	}
	public static  void moveToElement(WebElement tar) {
		Actions a=new Actions(driver);
		a.moveToElement(tar).perform();
	}
	public static void clickk(WebElement tar) {
		Actions a=new Actions(driver);
		a.click(tar).perform();
	}
	public static void dragAndDrop(WebElement src,WebElement tar) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, tar).perform();
	}
	public static void contextClick(WebElement tar) {
		Actions a=new Actions(driver);
		a.contextClick(tar).perform();
	}
	public static void doubleClick(WebElement tar) {
		Actions a=new Actions(driver);
		a.doubleClick(tar).perform();
	}
	public static void clickAndHold(WebElement tar) {
		Actions a=new Actions(driver);
		a.clickAndHold(tar).perform();
	}
	public static void keyEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void keyPressShift() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
	}
	public static void keyReleaseShift() throws AWTException {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void keyCopy() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void keyCut() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);	
	}
	public static void keyPaste() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void keyF5() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_F5);
		r.keyRelease(KeyEvent.VK_F5);
	}
	public static void keyDown() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void keyUp() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);
	}
	public static List<WebElement> getOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		return options;
	}
	public static List<WebElement> getAllSelectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}
	public static WebElement getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}
	public static boolean isMultiple(WebElement e) {
		Select s=new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public static void deselectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	public static void deselectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
	public static void deselectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.deselectByVisibleText(text);
	}
	public static void deselectAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	public static File takesScreenshotAs() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		return screenshotAs;

	}
	public static void javascriptExecutorSetAttribute(String txt,WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',"+txt+")", e);
	}
	public static void javascriptExecutorClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	public static Object javascriptExecutorGetAttribute(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", e);
		String string = executeScript.toString();
		return string;
	}
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);
	}
	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public static void switchToFrame(String NameorId) {
		driver.switchTo().frame(NameorId);
	}
	public static void switchToFrame(WebElement e) {
		driver.switchTo().frame(e);
	}
	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public static String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	public static Set<String> getWindowHandles(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>li=new LinkedList<>();
		li.addAll(windowHandles);
		driver.switchTo().window(li.get(i));
		return windowHandles;
	}
	public static void to(String url) {
		driver.navigate().to(url);
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static boolean isDiplayed(WebElement e) {
		boolean displayed = e.isDisplayed();
		return displayed;
	}
	public static boolean isEnabled(WebElement e) {
		boolean enabled = e.isEnabled();
		return enabled;
	}
	public static boolean isSelected(WebElement e) {
		boolean selected = e.isSelected();
		return selected;
	}
	public static String readExcel(String filename,String sheet,int row,int cell) throws IOException {
		File f=new File("C:\\Users\\MOHANRAJ K\\eclipse-workspace\\MavenJunitProject\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int ct = c.getCellType();
		String value=null;
		if(ct==1) {
			value = c.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
				value = sd.format(dateCellValue);
			}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l=(long)numericCellValue;
				value = String.valueOf(l);
			}
		}
		return value;

	}
	public static String updatExcel(String filename,String sheet,int row,int cell,String cellName) throws IOException {
		File f=new File("C:\\Users\\MOHANRAJ K\\eclipse-workspace\\MavenJunitProject\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
		Sheet s = w.getSheet(sheet);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(cellName);
		FileOutputStream ot=new FileOutputStream(f);
		w.write(ot);
		return cellName;
		
	}
}












