let currentPage = 0;

function loadBlogs(page) {
    $.ajax({
        url: `/api/blogs?page=${page}`,
        method: 'GET',
        success: function(data) {
            $('#blog-container').empty(); // 기존 블로그 항목 제거
            data.content.forEach(function(blog) {
                $('#blog-container').append(`<h3>${blog.title}</h3><p>${blog.content}</p>`);
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

