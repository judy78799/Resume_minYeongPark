let currentPage = 0;

function loadBlogs(page) {
    $.ajax({
        url: `/api/blogs?page=${page}&size=1&sort=date,desc`, // 한번에 가져올 블로그 수를 4로 설정, // 날짜 기준으로 내림차순 정렬
        method: 'GET',
        cache: false, // 캐시 방지
        success: function(data) {
            $('#blog-container').empty(); // 기존 블로그 항목 제거
            data.content.forEach(function(blog) {
                $('#blog-container').append(`
                     <div class="blog_card">
                        <h3>${blog.url}</h3>
                        <img src="${blog.image}">
                        <h3>${blog.title}</h3>
                        <p>${blog.content}</p>
                        <p><em>${blog.date}</em></p>
                    </div>
                `);
            });
            $('#page-info').text(`페이지 ${data.number + 1}`);
            $('#prev-button').prop('disabled', data.first);
            $('#next-button').prop('disabled', data.last);
        },
        error: function() {
            alert('블로그를 불러오는 데 실패했습니다.');
        }
    });
}


$(document).ready(function() {
    loadBlogs(currentPage); // 초기 로드

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

