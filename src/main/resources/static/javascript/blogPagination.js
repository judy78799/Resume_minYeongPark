let currentPage = 0;
const pageSize = 4; // 한 페이지에 표시할 블로그 수

function loadBlogs(page) {
    $('#loading').show(); // 로딩 애니메이션 표시
    $.ajax({
        url: `/api/blogs?page=${page}&size=${pageSize}&sort=id,asc`,
        method: 'GET',
        cache: false,
        success: function(data) {
            $('#blog-container').empty();
            data.content.forEach(function(blog) {
                $('#blog-container').append(`
                     <a href="${blog.url}" class="blog_card">
                        <img src="${blog.image}" class="blog_img" alt="Blog Image" onerror="this.onerror=null; this.src='/img/default-img.png';"> <!-- 기본 이미지 설정 -->
                        <h3 class="blog_title">${blog.title}</h3>
                        <p class="log_content">${blog.content}</p>
                        <p class="blog_date"><em>${blog.date}</em></p>
                    </a>
                `);
            });
            // #page-info의 자식 요소 수를 가져오기
            //var pageCount = $('#page-info').children().length;


            //$('#page-info').text(`페이지 ${data.number + 1}`);
 // 페이지 정보 업데이트
            updatePagination(data.totalPages, data.number);
            console.log("data.totalPages는?: "+data.totalPages);
            $('#prev-button').prop('disabled', data.first);
            $('#next-button').prop('disabled', data.last);
                (data.totalPages, data.number);
        },
        error: function() {
            alert('블로그를 불러오는 데 실패했습니다.');
        }
    });
}

function loadBlogs(page) {
    $('#loading').show(); // 로딩 애니메이션 표시
    $.ajax({
        url: `/api/blogs?page=${page}&size=${pageSize}&sort=date,desc`,
        method: 'GET',
        cache: false,
        success: function(data) {
            $('#blog-container').empty();
            data.content.forEach(function(blog) {
                $('#blog-container').append(`
                    <a href="${blog.url}" class="blog_card">
                        <img src="${blog.image}" class="blog_img" alt="Blog Image" onerror="this.onerror=null; this.src='/img/default-img.png';"> <!-- 기본 이미지 설정 -->
                        <h3 class="blog_title">${blog.title}</h3>
                        <p class="log_content">${blog.content}</p>
                        <p class="blog_date"><em>${blog.date}</em></p>
                    </a>
                `);
            });

            // 페이지 정보 업데이트
            updatePagination(data.totalPages, data.number);

            // 이전 및 다음 버튼 상태 업데이트
            $('#prev-button').prop('disabled', data.first);
            //$('#next-button').prop('disabled', data.last);    //이것 때문에 3을 누르면 작동이 안됨.
        },
        error: function() {
            alert('블로그를 불러오는 데 실패했습니다.');
        }
    });
}

function updatePagination(totalPages, currentPage) {
    const pageNumbersContainer = $('#page-info');
    pageNumbersContainer.empty(); // 기존 내용 초기화

    // 페이지 번호 표시
    //const totalPages = Math.ceil(results.length / itemsPerPage);
    const maxVisiblePages = 3; // 한 번에 보여줄 최대 페이지 수
    let startPage = Math.max(0, currentPage - Math.floor(maxVisiblePages / 2));
    let endPage = Math.min(totalPages, startPage + maxVisiblePages);

    // Adjust startPage if endPage is less than maxVisiblePages
    if (endPage - startPage < maxVisiblePages) {
        startPage = Math.max(0, endPage - maxVisiblePages);
    }

    // 페이지 번호 버튼 생성 1부터 3까지
    for (let i = startPage; i < endPage; i++) {
        const pageButton = $('<button></button>').text(i + 1);
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
        currentPage++;
        loadBlogs(currentPage);
    });
});
