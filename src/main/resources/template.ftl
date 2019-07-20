<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>学历</title>
    <style type="text/css">

        @page {
            size: 300mm 300mm;
        }

        html, body, div, a, ul, li, h4, h5, h6, pre, p, i, span, img, input, select, form, label, iframe {
            margin: 0;
            padding: 0;
            font-family: SimSun;
            color: #333333;
        }

        .clearfloat:after {
            display: block;
            clear: both;
            content: "";
            visibility: hidden;
            height: 0;
        }

        .clearfloat {
            zoom: 1;
        }

        .dy {
            position: absolute;
            top: 0;
            right: 80px;
            z-index: -1;
            width: 900px;
            height: 636px;
        }

        .dyTil {
            font-size: 30px;
            font-weight: bold;
            text-align: center;
            margin-top: 80px;
        }

        .dyConFl .gz {
            position: absolute;
            top: 300px;
            left: 320px;
            z-index: 33;
            width: 150px;
        }

        .dyConFl {
            float: left;
            width: 330px;
            padding-left: 150px;
            margin-top: 20px;
        }

        .dyConFl div {
            text-align: center;
        }

        .dyConFl div img {
            width: 160px;
        }

        .dyConFl p {
            margin-top: 10px;
            font-size: 20px;
            font-weight: bold;
        }

        .dyConFr p {
            font-size: 20px;
            font-weight: bold;
        }

        .dyConFr p:nth-child(2) {
            margin-top: 40px;
        }

        .dyConFr p:nth-child(3) {
            margin-top: 80px;
            text-align: right;
        }

        .dyConFr {
            float: right;
            width: 390px;
            margin-top: 80px;
            padding-right: 160px;
        }

        .dyConFr .gz1 {
            position: absolute;
            bottom: -20px;
            right: 140px;
            z-index: 33;
            width: 150px;
        }

        .dyConFr p span {
            border-bottom: 2px solid #000
        }

        .dyConFl p span {
            border-bottom: 2px solid #000
        }
    </style>
</head>
<body>
<div>
    <img class="dy" src="bj.png"/>

    <div class="dyTil">云南省全流程电子化招标投标从业人员培训合格证书</div>
    <div class="dyCon clearfloat">
        <div class="dyConFl">
            <img class="gz" src="gz.png"/>

            <div><img src="zp.png"/></div>

            <p>学员姓名：<span>${name}</span></p>

            <p>身份证号：<span>${idCard}</span></p>

            <p>证书编号：<span>${code}</span></p>

            <p>发证日期：<span>${startTime}</span></p>
        </div>
        <div class="dyConFr">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;于<span>${startTime}</span>云南省全流程电子化（招标/投标）从业人员培训，经考核合格，特发此证。</p>

            <p>
                证书有效期：<span>${startTime}</span>至<span>${endTime}</span>
            </p>

            <p>${startTime}</p>
            <img class="gz1" src="gz.png"/>
        </div>
    </div>
</div>
</body>
</html>