package test.AutomationPizza;

public class Repositories {
	
	
	
	public static String xpathlocator = "Xpathlocator";
	public static String csslocator = "CSSlocator";
	
	public static String url = "https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up";
	

	public static String welcome = "small.avm-welcome-notification-message";
	public static String getstartedPopup ="div[id='avaamo__popup']";
	public static String getstartedbtn = "a.get-started-link";
	public static String crossbtn ="div.avaamo__icon.avaamo__icon-open";
	public static String chatbot_image ="img[alt='Chat agent button']";
	public static String login_page ="//p[text()='Please enter your details to proceed']";
	public static String username_id = "//input[@id='first_name']";
	public static String email_id = "//input[@id='email']";
	public static String send_btn_xpath_btn="//button[@class='send btn']";
	public static String WelcomeToOrderPizza_Page_msg ="//p[text()='Welcome to McPizza Booking Journey']";
	public static String assignmentsassignments_image ="//img[contains(@src,'https://avaamoc6.s3.us-west-2.amazonaws.com/assets/data/000/118/729/original/image.png')]";

	public static String Inputbox_msg = "//textarea[@id='queryTextbox']";
	public static String send_msg_btn = "//button[@data-ele-name='send']";
	public static String username ="//div[@class='conversation-item clearfix mine']//h1[contains(@id,'name')]";
//	public static String sorry_msg ="//p[contains(text(),'I am sorry') and contains(text(),'have an answer for that.')]";
//	public static String suggestions =  "//div[@class='card_carousel ']//div[@class='default_card attachments']";
//	public static String suggestions_veg ="//a[@title='veg']";;
	public static String suggestions_non_veg = "//a[@title='non-veg']";
	public static String item_image = "(//div[@class='card_carousel ']//div[@class='default_card attachments'])[1]";
	public static String Thin_Crust ="(//a[contains(@href,'Thin')])[1]";
	public static String Thick_Crust ="(//a[contains(@href,'Thic')])[1]";
	public static String SelectGreat_msg="(//p[text()='Great ! You have Selected cheese'])[1]";
	public static String scroll_right_btn = "(//div[@aria-label='Bot sent, Carousel List.actions available. Use tab to navigate through the items.']//button[@class='navigator right'])[last()]";
	public static String pizza_size ="(//div[contains(text(),'Select Your Pizza Size')])[1]";
	public static String pizza_size_medium ="(//a[contains(@href,'Medium')])[1]";
	public static String McPizza_Order ="(//a[contains(@title,'McPizza order')])[1]";
	public static String yes_btn ="(//a[contains(@title,'Yes')])[1]";
	public static String No_btn ="(//a[contains(@title,'No')])[1]";
	public static String Order_placed ="(//div[contains(@aria-label,'Bot sent, Text.CONGRATS ! ORDER PLACED .')])[1]";
	public static String feedback_message ="(//div[@class='feedback-message'])[1]";
	public static String feedback_Thumbsup = "(//button[@aria-label='Thumbs up'])[1]";
	public static String feedback_Thumbsdown = "(//button[@aria-label='Thumbs down'])[1]";
	public static String custom_feedback ="(//h4[@id='custom_feedback_title'])[1]";
	public static String custom_feedback_close_btn ="(//div[@id='custom_feedback_header']//button[@aria-label='Close feedback'])";
	public static String try_again_msg ="(//p[text()='Would You Like to Try Again ?'])[1]";
	public static String select_toppings ="(//div[@data-ele-name='Select Your topping'])[1]";
	public static String toppings_beacons ="((//div[contains(@aria-label,'Bot sent, Card')])[last()]//input)[1]";
	public static String submit="((//div[contains(@aria-label,'Bot sent, Card')])[last()]//button[@aria-label='Submit'])[last()]";
	public static String sucessfully_beacon_selected="(//p[text()='Great ! You have Selected bacon'])[last()]";
	public static String size_small = "(//a[contains(@href,'Small')])[last()]";
	public static String Pizza_order_desc = "(//p[contains(text(),'Your Pizza Will Look like this :')])[last()]";
	public static String feedback_close_btn ="(//button[@aria-label='Close feedback'])[last()]";
	public static String select_toppings_popup = "(//div[contains(text(),'Select Your topping')])[last()]";
	public static String pick_list = "//input[@class='textbox picklist-textbox avm_pick_list_input']";
	public static String pick_list_item0 ="//li[@id='option0']";
	public static String pick_list_submit = "//input[@class='textbox picklist-textbox avm_pick_list_input']/../../../..//button[@class='btn default_card_submit']";
	public static String thanksyou_msg = "//div[@class='thankyou']";
	public static String last_msg = "(//p[@class='desc text-content '])[last()]";
	
	
	
	
}
