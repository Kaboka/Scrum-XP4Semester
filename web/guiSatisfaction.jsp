<%-- 
    Document   : Gui
    Created on : 18-09-2013, 10:49:27
    Author     : Mathias
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://code.jquery.com/jquery-latest.min.js">      
        </script>
        
        
        
        
        <link rel="stylesheet" type="text/css" href="CSS/SIPCSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electives</title>
        <script>
            $(function(){
                
                 $("#addA").click(function(){
                    alert("Im in AJAX")
                    $.ajax({url: "AjaxServlet",
                    cache: false,
                    dataType: "json",
                    success: ranking
                });});
        
               
                
        
           
            function ranking(data){
                $("#overview").append("<tr><td>Studentname coming</td><td>"+$("#poola1").text() +"</td><td>"+$("#poola2").text()
                        +"</td><td>"+$("#poolb1").text() +"</td><td>"+$("#poolb2").text() +"</td></tr>");
                $("#eSubjects > option").each(function() {
                   $("#overview tr:last").append("<td>" + $(this).text()+"</td></tr>"); 
                });
                
                $.each(data, function(i, obj){
                
                if(obj.tilfredshed === 1){
                   $("#overview").append("<tr><td style='background-color: red;'>"+ obj.name+"</td>"); 
                }
                if(obj.tilfredshed === 2){
                   $("#overview").append("<tr><td style='background-color: orange;'>"+ obj.name+"</td>"); 
                }
                if(obj.tilfredshed === 3){
                   $("#overview").append("<tr><td style='background-color: yellow;'>"+ obj.name+"</td>"); 
                }
                if(obj.tilfredshed === 4){
                   $("#overview").append("<tr><td style='background-color: green;'>"+ obj.name+"</td>"); 
                }
                //----------------------------------------------------------------------------------
                if(obj.forstePrio1.name  === $("#poola1").text()|| obj.forstePrio2.name  === $("#poola1").text()  ){
                     $("#overview tr:last").append("<td>1</td>"); 
                 }
                 else if(obj.andenPrio1.name  === $("#poola1").text()|| obj.andenPrio2.name === $("#poola1").text())
                     $("#overview tr:last").append("<td>2</td>"); 
                 else
                     $("#overview tr:last").append("<td>0</td>"); 
                
                 
                if(obj.forstePrio1.name  === $("#poola2").text() || obj.forstePrio2.name  === $("#poola2").text()  ){
                     $("#overview tr:last").append("<td>1</td>"); 
                 }
                 else if(obj.andenPrio1.name === $("#poola2").text()|| obj.andenPrio2.name === $("#poola2").text())
                     $("#overview tr:last").append("<td>2</td>"); 
                 else
                     $("#overview tr:last").append("<td>0</td>"); 
                 
                if(obj.forstePrio1.name  === $("#poolb1").text() || obj.forstePrio2.name  === $("#poolb1").text()  ){
                     $("#overview tr:last").append("<td>1</td>"); 
                 }
                 else if(obj.andenPrio1.name === $("#poolb1").text() || obj.andenPrio2.name === $("#poolb1").text())
                     $("#overview tr:last").append("<td>2</td>"); 
                 else
                     $("#overview tr:last").append("<td>0</td>"); 
                 
                if(obj.forstePrio1.name   === $("#poolb2").text() || obj.forstePrio2.name  === $("#poolb2").text()  ){
                     $("#overview tr:last").append("<td>1</td>"); 
                 }
                 else if(obj.andenPrio1.name === $("#poolb2").text() || obj.andenPrio2.name === $("#poolb2").text())
                     $("#overview tr:last").append("<td>2</td>"); 
                 else
                     $("#overview tr:last").append("<td>0</td>"); 
                 
                 
                
                $("#eSubjects > option").each(function() {
                    if(obj.forstePrio1.name  === $(this).text() || obj.forstePrio2.name  === $(this).text()  ){
                     $("#overview tr:last").append("<td>1</td>"); 
                 }
                 else if(obj.andenPrio1.name === $(this).text()|| obj.andenPrio2.name === $(this).text())
                     $("#overview tr:last").append("<td>2</td>"); 
                 else
                     $("#overview tr:last").append("<td>0</td>"); 
                }
                   
        
               
                 );
                 
                });
                
            }
                  });
        </script>
    </head>
    <body>
        <div id="frame" >
            <div class="subjects" id="electiveSubjects">
                <h4>Subjects</h4>
                <form method="POST" action="example.cgi">
                    <select id="eSubjects" name="eSubjects" size="15">
                        <option value="white">iOS</option>
                        <option value="red">Java</option>
                        <option value="yellow">SIP</option>
                        <option value="blue">PHP</option>
                        <option value="green">Tissemand</option>
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
                        <option id="poola1" value="white">Android</option>
                        <option id="poola2" value="red">Security</option>
                        
                    </select>
                </form>
            </div>
            
           
                
                <div class="subjects" id="PoolB" >
                <h4>Pool B</h4>
                <form method="POST">
                    <select name="color5" size="2" >
                        <option id="poolb1" value="white">CPlus</option>
                        <option id="poolb2" value="red">CSharp</option>
                        
                    </select>
                </form>
            </div>
            </div>
            <div style="clear:both;"></div>
            
            
            <div class="saveButton" >
                    <button id="Save" type="button" onclick="alert('Hello world!')">Save</button>
                </div>
                
            <div class ="tabelOverView" >
                <table class="tabelOverView" id="overview">
                        <tr>
                            <th class="tabelOverView" id="studname">Student Name</th>
                            <th class="tabelOverView" id="ovpoola" colspan="2">Pool A</th>
                            <th class="tabelOverView" id="ovpoolb" colspan="2">Pool B</th>
                            <th class="tabelOverView" id="ovnon" colspan="10">Not chosen subjects</th>
                        
                        </tr>
                        
                        
                        
                    </table>
                </div>
            <div style="clear: both;"></div>
        </div>

    </body>
</html>