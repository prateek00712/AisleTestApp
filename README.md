# AisleTestApp
Screen 1: Enter +91 in the country code field and 9876543212 in the phone number field and click on the Continue button. While clicking on the Continue button make a Phone number API call, Once you get success response then take the user to Screen 2.(only given data is used, static data cannot enter any other number.)

Screen 2: Enter 1234 in the OTP field and click on the Continue button. While clicking on the Continue button, make an OTP API call, You will receive an auth token in the API success response then take the user to Screen 3.(simply 1234 has been used as OTP to get response)

Screen 3: Add auth token in the header while making Notes API call.
(getting all the data and showing response from the particular token.)