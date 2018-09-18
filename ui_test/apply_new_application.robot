*** Settings ***
Library  SeleniumLibrary
Test Teardown   Close Browser

*** Variables ***

*** Test cases ***
อายุเท่ากับ 18 ปีและเงินเดือน 25,000 บาทต้องมีสิทธิ์สมัครบัตรเครดิต
    ไปยังหน้าการขอเปิดบัตรเครดิต
    กรอกข้อมูลของ ชนนิกานต์ โตบุญเรือง  
    Submit application form
    ต้องสามารถสมัครบัตรได้นะ

*** Keywords ***
ต้องสามารถสมัครบัตรได้นะ
    Alert Should Be Present    สมัครบัตรได้    action=LEAVE

Submit application form
    Click Element   id:submit

กรอกข้อมูลของ ชนนิกานต์ โตบุญเรือง
    Input Text    id:firstName   ชนนิกานต์
    Input Text    id:lastName    โตบุญเรือง
    Input Text    id:citizenID   1309902230169
    Input Text    id:birthDate   10/03/2000
    Input Text    id:income      25,000

ไปยังหน้าการขอเปิดบัตรเครดิต
    Open Browser  
    ...  http://10.10.99.42:8080/new_application.html
    ...  browser=gc 