<%-- 
    Document   : Gui
    Created on : 18-09-2013, 10:49:27
    Author     : Mathias
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electives</title>
    </head>
    <body>
        <div>
            <div id="subjects">
                <h4>Subjects</h4>
                <form method="POST" action="example.cgi">
                    <select name="color5" size="10" >
                        <option value="white">White</option>
                        <option value="red">Red</option>
                        <option value="yellow">Yellow</option>
                        <option value="blue">Blue</option>
                        <option value="green">Green</option>
                    </select>
                </form>
            </div>
            
            <div>
                <table>
                    <tr>
                        <th><button id="addA" type="button" onclick="alert('Hello world!')">--></button></th>
                    </tr>
                    <th><button id="RemoveA" type="button" onclick="alert('Hello world!')"><--</button></th>
                </table>
            </div>
            
            <div>
            <div id="PoolA">
                <h4>Pool A</h4>
                <form method="POST" action="example.cgi">
                    <select name="color5" size="10" >
                        <option value="white">White</option>
                        <option value="red">Red</option>
                        <option value="yellow">Yellow</option>
                        <option value="blue">Blue</option>
                        <option value="green">Green</option>
                    </select>
                </form>
            </div>
            
            <div>
                <table>
                    <tr>
                        <th><button id="addB" type="button" onclick="alert('Hello world!')">--></button></th>
                    </tr>
                    <th><button id="RemoveB" type="button" onclick="alert('Hello world!')"><--</button></th>
                </table>
            </div>
                
                 <div id="PoolB">
                <h4>Pool B</h4>
                <form method="POST" action="example.cgi">
                    <select name="color5" size="10" >
                        <option value="poolbwhite">White</option>
                        <option value="red">Red</option>
                        <option value="yellow">Yellow</option>
                        <option value="blue">Blue</option>
                        <option value="green">Green</option>
                    </select>
                </form>
            </div>
                
                <div>
                    <button id="Save" type="button" onclick="alert('Hello world!')">Save</button>
                </div>
                
                <div>
                    <table id="table">
                        <tr>
                        <th>Name</th><th>0</th><th>A</th><th>B</th>
                        </tr>
                        
                        
                    </table>
                </div>

        </div>

    </body>
</html>