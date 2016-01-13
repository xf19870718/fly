var isIE = document.all ? true : false;

(function () {
    String.prototype.trim = function () {
        return this.replace(/(^\s+)|(\s+$)/g, "");
    }
    String.prototype.lTrim = function () {
        return this.replace(/(^\s+)/g, "");
    }
    String.prototype.rTrim = function () {
        return this.replace(/(\s+$)/g, "");
    }
})();

var bool = function (flag) {
    return flag === "true" ? true : false;
};

var BooleanUtil = {
    isTure: function (obj) {
        if (typeof(obj) == "string") {
            if (str === "true") {
                return true;
            } else if (str === "false") {
                return false;
            } else {
                return null;
            }
        } else if (typeof(obj) == "number") {
            return obj == true;
        } else if (typeof(obj) == "boolean") {
            return obj;
        }
        else {
            return null;
        }
    }
};

var EventUtil = {

    getClipboardText: function (event) {
        var clipboardData = (event.clipboardData || window.clipboardData);
        return clipboardData.getData("text");
    },

    setClipboardText: function (event, value) {
        if (event.clipboardData) {
            return event.clipboardData.setData("text/plain", value);
        } else if (window.clipboardData) {
            return window.clipboardData.setData("text", value);
        }
    },

    addHandler: function (element, type, handler) {
        if (element.addEventListener) {
            element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.attachEvent("on" + type, handler);
        } else {
            element["on" + type] = handler;
        }
    },

    removeHandler: function (element, type, handler) {
        if (element.removeEventListener) {
            element.removeEventListener(type, handler, false);
        } else if (element.detachEvent) {
            element.detachEvent("on" + type, handler);
        } else {
            element["on" + type] = null;
        }
    },

    getEvent: function (event) {
        return event ? event : window.event;
    },

    getTarget: function (event) {
        return event.target || event.srcElement;
    },

    getRelatedTarget: function (event) {
        if (event.relatedTarget) {
            return event.relatedTarget;
        } else if (event.toElement) {
            return event.toElement;
        } else if (event.fromElement) {
            return event.fromElement;
        } else {
            return null;
        }

    },

    preventDefault: function (event) {
        if (event.preventDefault) {
            event.preventDefault();
        } else {
            event.returnValue = false;
        }
    },

    stopPropagation: function (event) {
        if (event.stopPropagation) {
            event.stopPropagation();
        } else {
            event.cancelBubble = true;
        }
    }

};

var toUN = {
    on: function (str) {
        var a = [],
            i = 0;
        for (; i < str.length;) a[i] = ("00" + str.charCodeAt(i++).toString(16)).slice(-4);
        return "\\u" + a.join("\\u");
    },
    un: function (str) {
        return unescape(str.replace(/\\/g, "%"));
    }
};


/**
 * for example:
 * var d = new Date();
 * var result = d.format("yyyy-MM-dd");
 */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)if (new RegExp("(" + k + ")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length == 1 ? o[k] :
                ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}


/**
 * @param elementId 对象ID
 * @return ID标识的对象
 */
function $id(elementId) {
    if (document.getElementById(elementId) != null) {
        return document.getElementById(elementId);
    } else {
        if (parent.document.getElementById(elementId) != null) {
            return parent.document.getElementById(elementId);
        } else {
            if (parent.parent.document.getElementById(elementId) != null) {
                return parent.parent.document.getElementById(elementId);
            } else {
                if (parent.parent.parent.document.getElementById(elementId) != null) {
                    return parent.parent.parent.document.getElementById(elementId);
                } else {
                    return parent.parent.parent.parent.document.getElementById(elementId);
                }
            }
        }
    }
}

/**
 * @param elementName 元素名
 * @return name属性值为给定名称(elementName)的元素集合
 */
function $names(elementNames) {
    if (document.getElementsByName(elementNames).length > 0) {
        return document.getElementsByName(elementNames);
    } else {
        return parent.document.getElementsByName(elementNames);
    }
}

/**
 * @param boxName checkboxs名称
 * @return 选中的数量
 */
function checkedCount(boxName) {
    var count = 0;
    var checks = $names(boxName);
    for (i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
            count++;
        }
    }
    return count;
}

/**
 * @param boxName checkbox或radio类型元素名
 * @return 选中的数量如果不唯一，则提示信息(如果第二个参数传递了自定义信息，则提示自定义信息)
 */
function uniCheckAlert(boxName) {
    if (!uniCheck(boxName)) {
        if (arguments[1] == null) {
            alert("请选择一条记录！");
        } else {
            alert(arguments[1]);
        }
        return false;
    }
    return true;
}

/**
 * @param boxName checkbox或radio类型元素名
 * @return 选中的数量是否唯一 是则为true,否则为false
 */
function uniCheck(boxName) {
    if (checkedCount(boxName) != 1) {
        return false;
    } else {
        return true;
    }
}

/**
 * @param checksName checkbox或radio名称
 * @return 选中的记录(一条)
 */
function getRecordId(checksName) {
    var checks = $names(checksName);
    for (i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
            return checks[i].value;
        }
    }
}

/**
 * @param checks checkbox对象(多选)
 * @return 把选中的checkbox值拼成串 e.g. (somevalue,somevalue,somevalue,...)
 */
function getIdStrForBat(checks) {
    var flg = false;
    var ids = '(';
    for (i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
            if (flg == false) {
                ids += checks[i].value;
                flg = true;
            } else {
                ids += ',' + checks[i].value;
            }
        }
    }
    ids += ')';
    return ids;
}

/**
 * @param obj 元素
 * @param attr 自定义属性
 * @return 如果obj不为空并且含有attr属性,刚返回attr对应的值,否则返回null
 */
function getCusAttrValue(obj, attr) {
    if (obj) {
        if (obj.attributes[attr]) {
            return obj.attributes[attr].nodeValue;
        }
        else {
            alert('属性不能为空!');
            return null;
        }
    } else {
        alert('对象不能为空!');
        return null;
    }
}

/**
 * @param objs checkbox或radio对象
 * @return 如果objs在不存则返回null,否则返回选中的对应集合
 */
function getSelecteds(objs) {
    if (!objs) {
        alert('对象不能为空!');
        return null;
    }
    var arr = new Array();
    var j = 0;
    var length = objs.length;
    for (i = 0; i < length; i++) {
        if (objs[i].checked) {
            arr[j] = objs[i];
            j++;
        }
    }
    return arr;
}

var ActJSON = {
    //追加一个JSON形式的字符串到另一个JSON形式的字符串中,返回最终串
    put: function (json, str) {
        if (json == '' || json == '{}') {
            return str;
        }
        return json.substr(0, json.length - 1) + "," + str.substr(1);
    },
    //把一对参数做成JSON形式的字符串，如id=100,返回{"id":"100"}
    mkPrm: function (paramName, paramValue) {
        return '{"' + paramName + '":"' + paramValue + '"}';
    },
    //把JSON形式的字符串转换成JSON对象
    toJSON: function (str) {
        return JSON.parse(str);
    },
    toString: function (obj) {
        return JSON.stringify(obj);
    }
};

/**
 *
 * @param url 原URL
 * @param params 参数集合，JSON对象
 * @return 拼接后的新URL
 */
function urlJoinParams(url, params) {
    if (!(params instanceof Object)) {
        params = JSON.parse(params);
    }
    for (key in params) {
        if (url.indexOf('?') == -1) {
            url += '?' + key + "=" + params[key];
        } else {
            url += '&' + key + "=" + params[key];
        }
    }
    return url;
}

/**
 * 取DOC的子标签文本值，主要用于自定义xml结构
 * @param doc doc结构树
 * @param tagName 子标签名
 * @param tagIndex 第几个子标签
 * @param nodeIndex 子标签的第几个结点
 * @return 目标结点值
 */
function $tagName(doc, tagName, tagIndex, nodeIndex) {
    tagIndex = arguments[2] || 0;
    nodeIndex = arguments[3] || 0;
    return doc.getElementsByTagName(tagName)[tagIndex].childNodes[nodeIndex].nodeValue;
}

/**创建AJAX对象*/

function createAjax() {
    /* Create a new XMLHttpRequest object to talk to the Web server */
    var xmlHttp = false;
    /*@cc_on @*/
    /*@if (@_jscript_version >= 5)
     try {
     xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
     } catch (e) {
     try {
     xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
     } catch (e2) {
     xmlHttp = false;
     }
     }
     @end @*/
    if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
        xmlHttp = new XMLHttpRequest();
    }
    //alert(xmlHttp);
    return xmlHttp;
}

/**
 * @param url 待请求的服务端地址
 * @param 第二个参数 method form method 默认'GET'
 * @param 第三个参数 func 异步请求时的响应函数引用(给定该参数就是异步请求，否则为同步)
 * @param 第四个以后的参数 args 响应函数参数
 * 描述：url必选参数，同步请求时，二参数可选，三四不选;异步请求时都是必选参数，二参数可以给定一个空字符串（若你的响应函数无参的话，则四及后面的参数都不选）
 * 同步请求时反回一个数组对象，该数组有两个元素，第一个是ajax返回的普通文本，第二个是ajax返回的DOM对象
 * @return
 */
function ajaxSend(url) {
    var ajax = createAjax();
    var method = arguments[1] || 'GET';
    method = method.toUpperCase();
    if (method != 'GET' && method != 'POST') {
        mehotd = 'GET';
    }
    var isAsyn = arguments[2] ? true : false;
    ajax.open(method, url, isAsyn);
    if (isAsyn) {
        var callBackMehod = arguments[2];
        var argCnt = arguments.length - 3;
        var argsArr = new Array(argCnt);
        for (i = 0; i < argCnt; i++) {
            argsArr[i] = arguments[3 + i];
        }
        argsArr.push(ajax);
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4) {
                if (ajax.status == 200) {
                    callBackMehod.apply(this, argsArr);
                }
            }
        };
        ajax.send(null);
        return ajax;
    }
    else {
        ajax.send(null);
        var arr = new Array(ajax.responseText);
        if (isIE) {
            arr.push(ajax.responseXML.documentElement);
        } else {
            var parser = new DOMParser();
            xml = parser.parseFromString(ajax.responseText, "text/xml");
            arr.push(xml);
        }
        return arr;
    }
}

//ev.returnValue = true; // IE 
//ev.preventDefault(); // Mozilla Firefox 

/**
 * @param event 事件
 * @param checkBoxName 待控的checkbox的name
 * @return
 */
function selectAll(event, checkBoxName) {
    var event = event ? event : window.event;
    var objs = $names(checkBoxName);
    for (i = 0; i < objs.length; i++) {
        var elm = event.srcElement ? event.srcElement : event.target;
        objs[i].checked = elm.checked;
    }
}
/**
 * 起radio作用的checkbox
 * @param hiddenName 需要传走的值
 * @param checkBoxName checkbox的名字
 * @return
 */
function likeRadio(hiddenName, checkBoxName) {
    var count = checkedCount(checkBoxName);
    var initValue = $(hiddenName).value;
    var checks = $names(checkBoxName);
    var len = checks.length;
    if (count == 1) {
        $(hiddenName).value = chooseOneRS(checkBoxName);
    }
    if (count == 2) {
        for (i = 0; i < len; i++) {
            if (checks[i].checked) {
                if (initValue == checks[i].value) {
                    checks[i].checked = false;
                } else {
                    $(hiddenName).value = checks[i].value;
                }
            }
        }
    }
}

/**
 * 选中一条记录的值
 * @param checkBoxName checkbox的名字
 * @return
 */
function chooseOneRS(checkBoxName) {
    var chId = 0;
    var checks = $names(checkBoxName);
    for (i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
            chId = i;
            break;
        }
    }
    return checks[chId].value;
}

/**
 * @param s money
 * @return 千分符money
 */
function parseMoney(s) {
    if (/[^0-9\.]/.test(s)) return "invalid value";
    s = s.replace(/^(\d*)$/, "$1.");
    s = (s + "00").replace(/(\d*\.\d\d)\d*/, "$1");
    s = s.replace(".", ",");
    var re = /(\d)(\d{3},)/;
    while (re.test(s))
        s = s.replace(re, "$1,$2");
    s = s.replace(/,(\d\d)$/, ".$1");
    return s.replace(/^\./, "0.");
}

function $root() {
    return $contextPath;
}

function $suffix() {
    return $extension;
}

function getAction(ns, actName) {
    return $root() + ns + actName + $suffix();
}