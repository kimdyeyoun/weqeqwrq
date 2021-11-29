<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MainPage</title>
    <style>
        html, body {margin: 0; padding: 0; height: 100%;}

        .container {
            display: grid;
            grid-template-columns: end;
        }

        .container_1 {
            display: grid;
            grid-template-rows: 100px;
            justify-content: center;
            justify-items: center;
            color: palevioletred;
        }

        .container_2 {
            background-color: burlywood;
            display: grid;
            grid-template-columns: repeat(4,100px);
            grid-template-rows: 50px;
            padding-top: 20px;
            border-collapse: collapse; border: 1px solid bisque;
            justify-content: center;
            justify-items: center;
        }

        .container_3 {
            width: 200px; height: 200px; margin-top: 50px; margin-left: auto; margin-right: auto; border: solid 1px #000;
            padding-top: 20px; padding-bottom: 20px; padding-left: 20px; padding-right: 20px;
            display: grid;
            grid-template-columns: repeat(1, 1fr);
            grid-template-rows: repeat(2, 1fr);
            border-collapse: collapse; border: 1px solid #000;

        }

        .container_4 {
            display: grid;
            grid-template-columns: repeat(6 , 1fr);
            grid-template-rows: repeat(1, 1fr);
        }

        .text_1{
            padding-top: 50px;
            display: flex;
            justify-content: center;
            justify-items: center;
        }

        .quest{
            padding-top: 210px;
            display: flex;
            justify-content: center;
            justify-items: end;
        }

        nav {
            display: block;
        }

        .res1{
            display: flex;
            padding-bottom: 5px;
            justify-content: center;
            justify-items: center;
        }

        .res2{
            display: flex;
            padding-right: 20px;
            justify-content: end;
            justify-items: end;
        }

        footer{
            width: 100%;
            height: 0%;
            bottom: 0px;
            position: absolute;
        }
        #head_1{margin-top: 3px; margin-right: 20px; display: flex; justify-content: end; justify-items: end;}
    </style>
</head>
<body>
<header>
    <div class="container">
        <div id="head_1">
            <span><a>로그인&nbsp;&nbsp;</a></span>
            <span><a>회원가입&nbsp;</a></span>
            <span><a>고객센터&nbsp;</a></span>
        </div>
    </div>
    <div class="container_1">
        <div><h1>def shop</h1></div>
    </div>

    <div class="container_2">
        <span>릴리</span>
        <span>베이지</span>
        <span>드라곤</span>
        <span>카멜레온</span>
    </div>

    <div style="color: red;" class="text_1">HOT`S</div>
</header>
<main>
    <div class="container_4">
            <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>
    </div>

    <div class="container_4">
            <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>

            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>

        <span class="container_3">
                <span>이미지1</span>
                <span class="quest">50000원</span>
            </span>
    </div>

    <footer>
        <div>
            <span class="res1">문의 010-2411-2164</span>
            <span class="res1">카카오톡 def2411</span>
        </div>
    </footer>
</main>
</body>
</html>