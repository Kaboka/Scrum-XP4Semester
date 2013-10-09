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
        <title>Select Course</title>
        <script>
            $(function() {
                var fPrio = new Array();
                var sPrio = new Array();

                $("#addFPrio").click(function() {
                    if ($("#eSubjects").val() != null && $("#fPrioList option").length < 2) {
                        $("#fPrioList").append(new Option($("#eSubjects").val(), $("#eSubjects").val()));
                        $("#eSubjects option[value='" + $("#eSubjects").val() + "']").remove();
                        makeArray();
                    } else {
                        alert("You can't choose more than two first priorities.");
                    }
                });

                $("#addSPrio").click(function() {
                    if ($("#eSubjects").val() != null && $("#sPrioList option").length < 2) {
                        $("#sPrioList").append(new Option($("#eSubjects").val(), $("#eSubjects").val()));
                        $("#eSubjects option[value='" + $("#eSubjects").val() + "']").remove();
                        makeArray();
                    } else {
                        alert("You can't choose more than two second priorities.");
                    }
                });

                $("#removeFPrio").click(function() {
                    if ($("#fPrioList").val() != null) {
                        $("#eSubjects").append(new Option($("#fPrioList").val(), $("#fPrioList").val()));
                        $("#fPrioList option[value='" + $("#fPrioList").val() + "']").remove();
                        makeArray();
                    }
                });

                $("#removeSPrio").click(function() {
                    if ($("#sPrioList").val() != null) {
                        $("#eSubjects").append(new Option($("#sPrioList").val(), $("#sPrioList").val()));
                        $("#sPrioList option[value='" + $("#sPrioList").val() + "']").remove();
                        makeArray();
                    }
                });

                $("#save").click(function() {
                    if ($("#fPrioList option").length === 2 && $("#sPrioList option").length === 2 && $("#studentID").val() !== "") {
                        if ($("#studentID").val().match(/^cph-[a-zA-Z][a-zA-Z]\d\d/))
                        {
                            saveStudentChoices();
                        } else {
                            alert("Please use your fronter username (ex. cph-aa11)");
                        }
                    } else if ($("#studentID").val() === "") {
                        alert("You have to insert your student ID (your Fronter username).");
                    } else if ($("#fPrioList option").length !== 2 && $("#sPrioList option").length !== 2) {
                        alert("You have to choose two first priorities and two second priorities.");
                    } else {
                        alert("You have to insert your student ID (your Fronter username) and choose two first priorities and two second priorities.");
                    }
                });

                function makeArray()
                {
                    fPrio = new Array();
                    sPrio = new Array();
                    
                    var count = 0;
                    $("#fPrioList > option").each(function() {
                        fPrio[count] = $(this).val();
                        count++;
                    });

                    count = 0;
                    $("#sPrioList > option").each(function() {
                        sPrio[count] = $(this).val();
                        count++;
                    });
                }

                function saveStudentChoices() {
                    if ($("#fPrioList option").length != 0 & $("#sPrioList option").length != 0) {
                        var json = JSON.stringify(fPrio);
                        var json2 = JSON.stringify(sPrio);
                        $.ajax({url: "AjaxServlet?command=persist&id=" + $("#studentID").val(),
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
                <input type="text" id="studentID" placeholder="Fronter username"/>
                <h4>Subjects</h4>
                
                    <select id="eSubjects" name="eSubjects" size="15">
                        <option value="C#">C#</option>
                        <option value="Apps and innovation">Apps and innovation</option>
                        <option value="HCI">HCI</option>
                        <option value="Globalization">Globalization</option>
                        <option value="Databases">Databases</option>
                        <option value="Test">Test</option>
                        <option value="Apps and innovation">Project management</option>
                        <option value="Algorithms">Algorithms</option>
                    </select>
          
            </div>

            <div class="chooseButton">
                <div class="poolbuttons"> 
                    <table id ="tableButton">
                        <tr>
                            <th><button id="addFPrio" type="button">--></button></th>
                        </tr>
                        <th><button id="removeFPrio" type="button"><--</button></th>
                    </table>
                </div>
                <div>
                    <table>
                        <tr>
                            <th><button id="addSPrio" type="button">--></button></th>
                        </tr>
                        <th><button id="removeSPrio" type="button"><--</button></th>
                    </table>
                </div>
            </div>
            <div class="choosenSubjects">
                <div class="subjects" id="PoolA">
                    <h4>First priority</h4>
                 
                        <select id="fPrioList"  size="2" >
                        </select>
                   
                </div>

                <div class="subjects" id="PoolB" >
                    <h4>Second priority</h4>
                
                        <select id="sPrioList"  size="2" >                      
                        </select>
                    
                </div>
            </div>
            <div style="clear:both;">
            </div>
            <div class="saveButton" >
                <button id="save" type="button">Save</button>
            </div>
        </div>
    </body>
</html>
