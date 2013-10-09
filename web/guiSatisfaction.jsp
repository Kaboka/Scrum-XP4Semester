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
            $(function() {
                var poolA = new Array();
                var poolB = new Array();

                $("#addA").click(function() {
                    if ($("#eSubjects").val() != null) {
                        $("#poolAList").append(new Option($("#eSubjects option:selected").text(), $("#eSubjects").val()));
                        $("#eSubjects option[value='" + $("#eSubjects").val() + "']").remove();
                        makeArray();
                        getStudents();
                    }
                });
                $("#addB").click(function() {
                    if ($("#eSubjects").val() != null) {
                        $("#poolBList").append(new Option($("#eSubjects option:selected").text(), $("#eSubjects").val()));
                        $("#eSubjects option[value='" + $("#eSubjects").val() + "']").remove();
                        makeArray();
                        getStudents();
                    }
                });
                $("#removeA").click(function() {
                    if ($("#poolAList").val() != null) {
                        $("#eSubjects").append(new Option($("#poolAList option:selected").text(), $("#poolAList").val()));
                        $("#poolAList option[value='" + $("#poolAList").val() + "']").remove();
                        makeArray();
                        getStudents();
                    }
                });
                $("#removeB").click(function() {
                    if ($("#poolBList").val() != null) {
                        $("#eSubjects").append(new Option($("#poolBList option:selected").text(), $("#poolBList").val()));
                        $("#poolBList option[value='" + $("#poolBList").val() + "']").remove();
                        makeArray();
                        getStudents();
                    }
                });

                $("#Test").click(function() {
                    var string = generateURL();
                    alert(string);
                });

                function makeArray()
                {
                    poolA = new Array;
                    poolB = new Array;
                    
                    var count = 0;
                    $("#poolAList > option").each(function() {
                        poolA[count] = $(this).val();
                        count++;
                    });

                    count = 0;
                    $("#poolBList > option").each(function() {
                        poolB[count] = $(this).val();
                        count++;
                    });
                }

                function generateURL() {
                    var result = "AjaxServlet?";
                    var count = 1;
                    var poolA = "poolACourse"
                    var poolB = "poolBCourse"
                    $("#poolAList > option").each(function() {
                        if (count === 1)
                        {
                            poolA = "poolACourse"
                            poolA += count
                            count++;
                            result += poolA + "=" + $(this).val();
                        } else {
                            poolA = "poolACourse"
                            poolA += count
                            count++;
                            result += "&" + poolA + "=" + $(this).val();
                        }
                    });

                    count = 1;
                    $("#poolBList > option").each(function() {
                        poolB = "poolBCourse"
                        poolB += count
                        count++;
                        result += "&" + poolB + "=" + $(this).val();
                    });
                    return result;
                }

                function getStudents() {
                    if ($("#poolAList option").length != 0 & $("#poolBList option").length != 0) {
                        //   var url = generateURL();
                        var json = JSON.stringify(poolA);
                        var json2 = JSON.stringify(poolB);
                        $.ajax({url: "AjaxServlet",
                            cache: false,
                            dataType: "json",
                            data: {poolA: json, poolB: json2},
                            success: ranking
                        });
                    }
                }

                function ranking(data) {
                    $("#overview tr.remove").remove();
                    var count = 0;
                    $("#overview").append("<tr class='remove'><td class='tabelOverView'></td></tr>");
                    $("#poolAList > option").each(function() {
                        $("#overview tr:last").append("<td class='tabelOverView'>" + $(this).text() + "</td></tr>");
                        count++;
                    });
                    $("#ovPoolA").attr('colspan', count);
                    count = 0;
                    $("#poolBList > option").each(function() {
                        $("#overview tr:last").append("<td class='tabelOverView'>" + $(this).text() + "</td></tr>");
                        count++;
                    });
                    $("#ovPoolB").attr('colspan', count);
                    count = 0;
                    $("#eSubjects > option").each(function() {
                        $("#overview tr:last").append("<td class='tabelOverView'>" + $(this).text() + "</td></tr>");
                        count++;
                    });
                    $("#ovNon").attr('colspan', count);
                    $.each(data, function(i, obj) {

                        //Color
                        if (obj.tilfredshed === 1) {
                            $("#overview").append("<tr class='remove'><td style='background-color: red;'>" + obj.name + "</td>");
                        }
                        if (obj.tilfredshed === 2) {
                            $("#overview").append("<tr class='remove'><td style='background-color: orange;'>" + obj.name + "</td>");
                        }
                        if (obj.tilfredshed === 3) {
                            $("#overview").append("<tr class='remove'><td style='background-color: yellow;'>" + obj.name + "</td>");
                        }
                        if (obj.tilfredshed === 4) {
                            $("#overview").append("<tr class='remove'><td style='background-color: green;'>" + obj.name + "</td>");
                        }

                        //Numbers
                        $("#poolAList > option").each(function() {
                            if (obj.forstePrio1.name === $(this).text() || obj.forstePrio2.name === $(this).text()) {
                                $("#overview tr:last").append("<td class='tabelOverView'>1</td>");
                            } else if (obj.andenPrio1.name === $(this).text() || obj.andenPrio2.name === $(this).text()) {
                                $("#overview tr:last").append("<td class='tabelOverView'>2</td>");
                            } else {
                                $("#overview tr:last").append("<td class='tabelOverView'>0</td>");
                            }
                        });
                        $("#poolBList > option").each(function() {
                            if (obj.forstePrio1.name === $(this).text() || obj.forstePrio2.name === $(this).text()) {
                                $("#overview tr:last").append("<td class='tabelOverView'>1</td>");
                            } else if (obj.andenPrio1.name === $(this).text() || obj.andenPrio2.name === $(this).text()) {
                                $("#overview tr:last").append("<td class='tabelOverView'>2</td>");
                            } else {
                                $("#overview tr:last").append("<td class='tabelOverView'>0</td>");
                            }
                        });
                        $("#eSubjects > option").each(function() {
                            if (obj.forstePrio1.name === $(this).text() || obj.forstePrio2.name === $(this).text()) {
                                $("#overview tr:last").append("<td class='tabelOverView'>1</td>");
                            } else if (obj.andenPrio1.name === $(this).text() || obj.andenPrio2.name === $(this).text()) {
                                $("#overview tr:last").append("<td class='tabelOverView'>2</td>");
                            } else {
                                $("#overview tr:last").append("<td class='tabelOverView'>0</td>");
                            }
                        });
                    });
                }
            });
        </script>
    </head>
    <body>
        <div id="frame" >
            <div class="subjects" id="electiveSubjects">
                <h4>Subjects</h4>
               
                    <select id="eSubjects" name="eSubjects" size="15">
                        <option value="C#">C#</option>
                        <option value="Apps_and_innovation">Apps and innovation</option>
                        <option value="HCI">HCI</option>
                        <option value="Globalization">Globalization</option>
                        <option value="Databases">Databases</option>
                        <option value="Test">Test</option>
                        <option value="Project_management">Project management</option>
                        <option value="Algorithms">Algorithms</option>
                    </select>
             
            </div>

            <div class="chooseButton">
                <div class="poolbuttons"> 
                    <table id ="tableButton">
                        <tr>
                            <th><button id="addA" type="button">--></button></th>
                        </tr>
                        <th><button id="removeA" type="button"><--</button></th>

                    </table>

                </div>
                <div>
                    <table>
                        <tr>
                            <th><button id="addB" type="button">--></button></th>
                        </tr>
                        <th><button id="removeB" type="button"><--</button></th>
                    </table>
                </div>
            </div>
            <div class="choosenSubjects">
                <div class="subjects" id="PoolA">
                    <h4>Pool A</h4>
                
                        <select id="poolAList" size="2" >
                        </select>
              
                </div>

                <div class="subjects" id="PoolB" >
                    <h4>Pool B</h4>
                
                        <select id="poolBList"  size="2" >                      
                        </select>
                 
                </div>
            </div>
            <div style="clear:both;"></div>


            <div class="saveButton" >
                <button id="Save" type="button">Save</button>
            </div>

            <div class ="tabelOverView" >
                <table class="tabelOverView" id="overview">
                    <tr>
                        <th class="tabelOverView" id="studName" colspan="1">Student Name</th>
                        <th class="tabelOverView" id="ovPoolA" colspan="3">Pool A</th>
                        <th class="tabelOverView" id="ovPoolB" colspan="1">Pool B</th>
                        <th class="tabelOverView" id="ovNon" colspan="10">Not chosen subjects</th>
                    </tr>
                </table>
            </div>
            <div style="clear: both;"></div>
        </div>
        <div>
            <button id="Test" type="button">Generate URL</button>
        </div>
    </body>
</html>
