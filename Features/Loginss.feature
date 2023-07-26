Feature: Login

Scenario: Succefull Login With Valid Credintials
Given user launch chrome browser
When user opens url "https://admin-demo.nopcommerce.com/login"
When user enters Email as "admin@yourstore.com" and password as "admin"
When click login
Then page title should be "Dashboard / nopCommerce administration"
When  user clicks logout button
Then page title should be "Your store. Login"
And close browser

