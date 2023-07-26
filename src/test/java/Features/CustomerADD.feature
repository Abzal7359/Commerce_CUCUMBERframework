Feature: customers

Background:
Given user launch chrome browser
When user opens url "https://admin-demo.nopcommerce.com/login"
When user enters Email as "admin@yourstore.com" and password as "admin"
When click login
Then user view dashboard
When user click on cutomer menu
And user clicks on customer menu item


Scenario: Add new Customer
And click on add new button
Then user can view Add new customer page
When user enter customer info
And click on save button
Then user can view confirmation message		
And close browser
#//div[contains(@class,'alert-success')]


Scenario: Search customer by email id
And Enter customer mail
When click on search button
Then user should find email in the search table 
And close browser

Scenario: Search Customer by name
And Enter customer firstname
And Enter cutomer lastname
Then user should find Name in the search table
And close browser


