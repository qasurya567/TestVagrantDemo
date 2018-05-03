Feature: To complete the flow of buying a ticket from Cleartrip

@CaseSetup
Scenario: Step by Step Execution of Payment Flow on Cleartrip 
Given I am navigating to site
And Select kind of Trip as "Round trip"
And Select Booking From "Bangalore, IN - Kempegowda International Airport (BLR)" to "Varanasi, IN - Lal Bahadur Shastri (VNS)"
And Select DepartDate as "Fri, 25 May, 2018" and ReturnDate as "Sun, 27 May, 2018"
And Click on Search button
And Conform Booking from Second Page
And Pass Itenerary on Third page
And Fill Traveller information as "Mr" "Surya" "Singh" "9886482910" and Continue to payment
Then Conform the payment option is Displayed 

@CaseSetup
Scenario: Step by Step Execution of HotelBooking Flow on Cleartrip
 Given I am navigating to site
 And Clicking on "Hotels" tab
 And Serching for hotel in "Indiranagar, Bangalore" locality
 And Booking hotel from "Fri, 25 May, 2018" to "Sun, 27 May, 2018"
 And Selecting "1 room, 2 adults" from travellers dropdown
 And clicked on search Hotels tab
 And Booking selecting room from "Treebo Annora" Hotel
 Then Clicked on book This Hotel
 
 @CaseSetup
 Scenario: Step by Step Execution of SignIn Flow on Cleartrip
 Given I am navigating to site
 And I clicked on SignIn Button
 And Entering "qasurya567@gmail.com" as username
 And Entering "abcd1234" as as password
 Then clicked on signin button and verifying home page title
 
 