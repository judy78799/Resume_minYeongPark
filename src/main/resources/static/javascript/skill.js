let skill_summary_ver_wrap = document.getElementById("skill_summary_ver_wrap");
let skill_contents_ver_wrap = document.getElementById("skill_contents_ver_wrap");

//한눈에 보기 버튼 클릭하면 ~skill_summary_ver_wrap 보여줘
document.getElementById('skill_all_btn').addEventListener('click', function() {
    skill_summary_ver_wrap.style.display = "flex";
    skill_contents_ver_wrap.style.display = "none";
    console.log("스킬 올인원 버튼이 눌렸습니다.");
});
//설명 보기 버튼 클릭하면 ~skill_contents_ver_wrap 보여줘
document.getElementById('skill_description_btn').addEventListener('click', function() {
    skill_summary_ver_wrap.style.display = "none";
    skill_contents_ver_wrap.style.display = "flex";
    console.log("스킬 설명 버튼이 눌렸습니다.");
});

//Bar 바탕이 되는 부모 position:relative
let skill_summary_card = document.getElementsByClassName("skill_summary_card");
for (let i = 0; i < skill_summary_card.length; i++) {
    skill_summary_card[i].innerHTML += "<span></span>";
}

let springBoot = document.getElementById('springBoot');
springBoot.innerHTML = springBoot.innerHTML + "<span></span>";

let spring = document.getElementById('spring');
spring.innerHTML = spring.innerHTML + "<span></span>";

let java = document.getElementById('java');
java.innerHTML = java.innerHTML + "<span></span>";

let javascript = document.getElementById('javascript');
javascript.innerHTML = javascript.innerHTML + "<span></span>";

let jQuery = document.getElementById('jQuery');
jQuery.innerHTML = jQuery.innerHTML + "<span></span>";

let nodeJs = document.getElementById('nodeJs');
nodeJs.innerHTML = nodeJs.innerHTML + "<span></span>";

let react = document.getElementById('react');
react.innerHTML = react.innerHTML + "<span></span>";

let db = document.getElementById('db');
db.innerHTML = db.innerHTML + "<span></span>";
