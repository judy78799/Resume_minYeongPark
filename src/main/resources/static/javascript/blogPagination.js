let currentPage = 0;
const pageSize = 4; // 한 페이지에 표시할 블로그 수
//총 페이지 수 = Math.ceil(전체 컨텐츠 개수 / 한 페이지에 보여주고자 하는 컨텐츠의 개수)
totalPages = 3;
function loadBlogs(page) {
    $('#loading').show(); // 로딩 애니메이션 표시
    $('#prev-button, #next-button').prop('disabled', true); // 버튼 비활성화

    $.ajax({
        url: `/api/blogs?page=${page}&size=${pageSize}&sort=date,desc`,
        method: 'GET',
        cache: false,
        success: function(data) {
            $('#blog-container').empty();
            data.content.forEach(function(blog) {
                $('#blog-container').append(`
                    <a href="${blog.url}" class="blog_card">
                        <img src="${blog.image}" class="blog_img" alt="Blog Image" onerror="this.onerror=null; this.src='/img/default-img.png';">
                        <h3 class="blog_title">${blog.title}</h3>
                        <p class="blog_content">${blog.content}</p>
                        <p class="blog_date">${blog.date}</p>
                    </a>
                `);
            });

            // 페이지 정보 업데이트
            updatePagination(data.totalPages, data.number);

            // 이전 및 다음 버튼 상태 업데이트
            $('#prev-button').prop('disabled', data.first);
            $('#next-button').prop('disabled', data.last);
        },
        error: function() {
            alert('블로그를 불러오는 데 실패했습니다.');
        },
        complete: function() {
            $('#prev-button, #next-button').prop('disabled', false); // 버튼 활성화
        }
    });
}

function updatePagination(totalPages, currentPage) {
    const pageNumbersContainer = $('#page-info');
    pageNumbersContainer.empty(); // 기존 내용 초기화

    // 페이지 번호 버튼 생성
    for (let i = 0; i < totalPages; i++) {
        const pageButton = $('<button class="pageBtn btn_common_style"></button>').text(i + 1);
        pageButton.prop('disabled', (i === currentPage));
        pageButton.click(() => {
            currentPage = i; // 현재 페이지 업데이트
            loadBlogs(currentPage); // 새로운 페이지 로드
        });
        pageNumbersContainer.append(pageButton);
    }

    // 첫 번째 및 마지막 버튼
    $('#first-button').off('click').on('click', function() {
        currentPage = 0;
        loadBlogs(currentPage);
    });

    $('#last-button').off('click').on('click', function() {
        currentPage = totalPages - 1;
        loadBlogs(currentPage);
    });

    // 이전 및 다음 버튼 상태 업데이트
    $('#prev-button').prop('disabled', currentPage === 0);
    $('#next-button').prop('disabled', currentPage === totalPages - 1);
}








//function updatePagination(totalPages, currentPage) {
//    $('#page-info').empty();
//
//    for (let i = 0; i < totalPages; i++) {
//        const pageNumber = $('<button></button>').text(i + 1).click(function() {
//            currentPage = i;
//            loadBlogs(currentPage);
//        });
//        if (i === currentPage) {
//            pageNumber.prop('disabled', true); // 현재 페이지는 비활성화
//        }
//        $('#page-info').append(pageNumber);
//    }
//
//    $('#first-button').off('click').on('click', function() {
//        currentPage = 0;
//        loadBlogs(currentPage);
//    });
//
//    $('#last-button').off('click').on('click', function() {
//        currentPage = totalPages - 1;
//        loadBlogs(currentPage);
//    });
//
//
////      const pageNumbersContainer = document.getElementById('page-numbers');
////      pageNumbersContainer.innerHTML = '';            // 기존 내용 초기화
////     // 페이지 번호 표시
////          const startPage = Math.floor((currentPage - 1) / 5) * 5 + 1;
////          const endPage = Math.min(startPage + 4, totalPages);
////
////          for (let i = startPage; i <= endPage; i++) {
////            const pageButton = document.createElement('button');
////            pageButton.textContent = i;
////            pageButton.disabled = (i === currentPage);
////            pageButton.onclick = () => {
////              currentPage = i;
////              displayResults(data);             // 수정된 부분
////            };
////            pageNumbersContainer.appendChild(pageButton);
//}

$(document).ready(function() {
    loadBlogs(currentPage);

    $('#prev-button').click(function() {
        if (currentPage > 0) {
            currentPage--;
            loadBlogs(currentPage);
        }
    });

    $('#next-button').click(function() {
        if (currentPage < totalPages - 1) { // totalPages가 필요
            currentPage++;
            loadBlogs(currentPage);
        } else {
            alert('마지막 페이지입니다.'); // 마지막 페이지일 때 알림
        }
    });
});
