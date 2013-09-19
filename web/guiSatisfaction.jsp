<%-- 
    Document   : Gui
    Created on : 18-09-2013, 10:49:27
    Author     : Mathias
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="CSS/SIPCSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electives</title>
    </head>
    <body>
        <div id="frame" >
            <div class="subjects" id="electiveSubjects">
                <h4>Subjects</h4>
                <form method="POST" action="example.cgi">
                    <select name="color5" size="15">
                        <option value="white">White</option>
                        <option value="red">Red</option>
                        <option value="yellow">Yellow</option>
                        <option value="blue">Blue</option>
                        <option value="green">Green</option>
                    </select>
                </form>
            </div>
            
            <div class="chooseButton">
                <div class="poolbuttons"> 
                    <table id ="tableButton">
                    <tr>
                        <th><button id="addA" type="button" onclick="alert('Hello world!')">--></button></th>
                    </tr>
                    <th><button id="RemoveA" type="button" onclick="alert('Hello world!')"><--</button></th>
                    
                </table>
                
            </div>
             <div>
                <table>
                    <tr>
                        <th><button id="addB" type="button" onclick="alert('Hello world!')">--></button></th>
                    </tr>
                    <th><button id="RemoveB" type="button" onclick="alert('Hello world!')"><--</button></th>
                </table>
            </div>
            </div>
            <div class="choosenSubjects">
                <div class="subjects" id="PoolA">
                <h4>Pool A</h4>
                <form method="POST" >
                    <select name="color5" size="2" >
                        <option value="white">White</option>
                        <option value="red">Red</option>
                        <option value="yellow">Yellow</option>
                        <option value="blue">Blue</option>
                        <option value="green">Green</option>
                    </select>
                </form>
            </div>
            
           
                
                <div class="subjects" id="PoolB" >
                <h4>Pool B</h4>
                <form method="POST">
                    <select name="color5" size="2" >
                        <option value="poolbwhite">White</option>
                        <option value="red">Red</option>
                        <option value="yellow">Yellow</option>
                        <option value="blue">Blue</option>
                        <option value="green">Green</option>
                    </select>
                </form>
            </div>
            </div>
            <div style="clear:both;"></div>
            
            
            <div class="saveButton" >
                    <button id="Save" type="button" onclick="alert('Hello world!')">Save</button>
                </div>
                
            <div class ="tabelOverView" >
                <table class="tabelOverView ">
                        <tr>
                            <th class="tabelOverView">Student Name</th><th class="tabelOverView">Not chosen subjects</th><th class="tabelOverView">Pool A</th><th class="tabelOverView">Pool B</th>
                        
                        </tr>
                        <tr><td>TEst</td><td>test</td><td>test</td><td>test</td></tr>
                        
                        
                    </table>
                </div>
            <div style="clear: both;"></div>
        </div>

    </body>
</html>