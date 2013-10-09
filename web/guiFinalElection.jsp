<%-- 
    Document   : FirstElection
    Created on : 03-10-2013, 09:25:15
    Author     : Søren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <link rel="stylesheet" type="text/css" href="CSS/SIPCSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
          <script src="http://code.jquery.com/jquery-latest.min.js">
        </script>
      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Course</title>
        <script>
            $(function() {
                var fPrio = new Array();
                var sPrio = new Array();
                
                
                $.ajax({url: "AjaxServlet?command=getPools",
                    cache: false,
                    dataType: "json",
                    success: genPools
                });
                
                
                function genPools(data){

                    var ArrayPoolA = data[0];
                    var ArrayPoolB = data[1]; 
                    
                    $.each(ArrayPoolA, function(i, obj){
                        $("#eSubjectsPoolA").append("<option value='"+obj.toString()+"'>"+obj.toString()+"</option>");
                    });
                    $.each(ArrayPoolB, function(i, obj){
                        $("#eSubjectsPoolB").append("<option value='"+obj.toString()+"'>"+obj.toString()+"</option>");
                    });
//                    element = null;
//                    for(var i = 0; i < ArrayPoolA.length; i++){
//                        for(var j = 0; i <)
//                        element = ArrayPoolA[i];
//                        $("#eSubjectsPoolA").append("<option value='"+element.toString()+"'>"+element.toString()+"</option>");
//                    }
                }

                $("#addA1").click(function() {
                    if ($("#eSubjectsPoolA").val() != null && $("#poolA1List option").length < 1) {
                        $("#poolA1List").append(new Option($("#eSubjectsPoolA").val(), $("#eSubjectsPoolA").val()));
                        $("#eSubjectsPoolA option[value='" + $("#eSubjectsPoolA").val() + "']").remove();
                        makeArray();
                    } else {
                        alert("You can't choose more than one first priorities.");
                    }
                });
                $("#addA2").click(function() {
                    if ($("#eSubjectsPoolA").val() != null && $("#poolA2List option").length < 1) {
                        $("#poolA2List").append(new Option($("#eSubjectsPoolA").val(), $("#eSubjectsPoolA").val()));
                        $("#eSubjectsPoolA option[value='" + $("#eSubjectsPoolA").val() + "']").remove();
                        makeArray();
                    } else {
                        alert("You can't choose more than one second priorities.");
                    }
                });
                $("#addB1").click(function() {
                    if ($("#eSubjectsPoolB").val() != null && $("#poolB1List option").length < 1) {
                        $("#poolB1List").append(new Option($("#eSubjectsPoolB").val(), $("#eSubjectsPoolB").val()));
                        $("#eSubjectsPoolB option[value='" + $("#eSubjectsPoolB").val() + "']").remove();
                        makeArray();
                    } else {
                        alert("You can't choose more than one first priorities.");
                    }
                });
                $("#addB2").click(function() {
                    if ($("#eSubjectsPoolB").val() != null && $("#poolB2List option").length < 1) {
                        $("#poolB2List").append(new Option($("#eSubjectsPoolB").val(), $("#eSubjectsPoolB").val()));
                        $("#eSubjectsPoolB option[value='" + $("#eSubjectsPoolB").val() + "']").remove();
                        makeArray();
                    } else {
                        alert("You can't choose more than one second priorities.");
                    }
                });

                
                
                $("#removeA1").click(function() {
                    if ($("#poolA1List").val() != null) {
                        $("#eSubjectsPoolA").append(new Option($("#poolA1List").val(), $("#poolA1List").val()));
                        $("#poolA1List option[value='" + $("#poolA1List").val() + "']").remove();
                        makeArray();
                    }
                });
                $("#removeA2").click(function() {
                    if ($("#poolA2List").val() != null) {
                        $("#eSubjectsPoolA").append(new Option($("#poolA2List").val(), $("#poolA2List").val()));
                        $("#poolA2List option[value='" + $("#poolA2List").val() + "']").remove();
                        makeArray();
                    }
                });
                $("#removeB1").click(function() {
                    if ($("#poolB1List").val() != null) {
                        $("#eSubjectsPoolB").append(new Option($("#poolB1List").val(), $("#poolB1List").val()));
                        $("#poolB1List option[value='" + $("#poolB1List").val() + "']").remove();
                        makeArray();
                    }
                });
                $("#removeB2").click(function() {
                    if ($("#poolB2List").val() != null) {
                        $("#eSubjectsPoolB").append(new Option($("#poolB2List").val(), $("#poolB2List").val()));
                        $("#poolB2List option[value='" + $("#poolB2List").val() + "']").remove();
                        makeArray();
                    }
                });

                

                $("#save").click(function() {
                    if ($("#poolA1List option").length === 1 && $("#poolA2List option").length === 1 && $("#poolB1List option").length === 1 && $("#poolB2List option").length === 1 && $("#studentID").val() !== "") {
                        if ($("#studentID").val().match(/^cph-[a-zA-Z][a-zA-Z]\d\d/))
                        {
                            saveStudentChoices();
                        } else {
                            alert("Please use your fronter username (ex. cph-aa11)");
                        }
                    }else if ($("#studentID").val() === "") {
                        alert("You have to insert your student ID (your Fronter username).");
                    }else if ($("#poolA1List option").length !== 1 || $("#poolA2List option").length !== 1 || $("#poolB1List option").length !== 1 || $("#poolB2List option").length !== 1) {
                        alert("You have to choose a first priority and a second priority from each pool.");
                    }else{
                        alert("You have to insert your student ID (your Fronter username) and choose a first priority and a second priority from each pool.");
                    }
                });

                function makeArray()
                {
                    
                    $("#poolA1List > option").each(function() {
                        fPrio[0] = $(this).val();
                        
                        
                    });
                    $("#poolA2List > option").each(function() {
                        sPrio[0] = $(this).val();
                        
                        
                    });
                    $("#poolB1List > option").each(function() {
                        fPrio[1] = $(this).val();
                        
                        
                    });
                    $("#poolB2List > option").each(function() {
                        sPrio[1] = $(this).val();
                        
                        
                    }); 
                }

                function saveStudentChoices() {
                    if ($("#poolA1List option").length != 0 & $("#poolA2List option").length != 0 & $("#poolB1List option").length != 0 & $("#poolB2List option").length != 0) {
                        
                        var json = JSON.stringify(fPrio);
                        var json2 = JSON.stringify(sPrio);
                        $.ajax({url: "AjaxServlet?id=" + $("#studentID").val(),
                       
                            cache: false,
                            dataType: "json",
                            data: {fPrio: json, sPrio: json2},
                            succes: $("#save").prop('disabled', true)
                        });
                    }
                }
            });
        </script>
    </head>
     <body>
        <div id="frame" >
           
            
            <div class="subjects" id="electiveSubjects">
                <label for="studentID">Student ID</label>
                <input type="text" id="studentID" placeholder="Fronter username" />
                
                
                <h4>Pool A</h4>
                <form method="POST" action="example.cgi">
                    <select id="eSubjectsPoolA" class="ePools" name="eSubjects" size="15">
                    </select>
                </form>
            </div>

            <div class="chooseButton">
                <div class="poolbuttons"> 
                    <table id ="tableButton">
                        <tr>
                            <th><button id="addA1" type="button">--></button></th>
                        </tr>
                        <th><button id="removeA1" type="button"><--</button></th>

                    </table>

                </div>
                <div>
                    <table>
                        <tr>
                            <th><button id="addA2" type="button">--></button></th>
                        </tr>
                        <th><button id="removeA2" type="button"><--</button></th>
                    </table>
                </div>
            </div>
            <div class="choosenSubjects">
                <div class="subjects" id="PoolA">
                    <h4>1. Prioritet</h4>
                    <form method="POST" >
                        <select id="poolA1List" name="color5" size="2" >
                        </select>
                    </form>
                </div>

                <div class="subjects" id="PoolB" >
                    <h4>2. Prioritet</h4>
                    <form method="POST">
                        <select id="poolA2List" name="color5" size="2" >                      
                        </select>
                    </form>
                </div>
            </div>
            <div style="clear:both;"></div>
            
             <div class="subjects" id="electiveSubjects">
                <h4>Pool B</h4>
                <form method="POST" action="example.cgi">
                    <select id="eSubjectsPoolB" class="ePools" name="PoolB" size="15">
                    </select>
                </form>
            </div>

            <div class="chooseButton">
                <div class="poolbuttons"> 
                    <table id ="tableButton">
                        <tr>
                            <th><button id="addB1" type="button">--></button></th>
                        </tr>
                        <th><button id="removeB1" type="button"><--</button></th>

                    </table>

                </div>
                <div>
                    <table>
                        <tr>
                            <th><button id="addB2" type="button">--></button></th>
                        </tr>
                        <th><button id="removeB2" type="button"><--</button></th>
                    </table>
                </div>
            </div>
            <div class="choosenSubjects">
                <div class="subjects" id="PoolA">
                    <h4>1. Prioritet</h4>
                    <form method="POST" >
                        <select id="poolB1List" name="poolb1prio" size="2" >
                        </select>
                    </form>
                </div>

                <div class="subjects" id="PoolB" >
                    <h4>2. Prioritet</h4>
                    <form method="POST">
                        <select id="poolB2List" name="poolb2prio" size="2" >                      
                        </select>
                    </form>
                </div>
            </div>
            <div style="clear:both;"></div>


            <div class="saveButton" >
                <button id="save" type="button">Save</button>
            </div>

            
            <div style="clear: both;"></div>
        </div>
        <div>
            <button id="Test" type="button">Generate URL</button>
        </div>
    </body>
</html>
