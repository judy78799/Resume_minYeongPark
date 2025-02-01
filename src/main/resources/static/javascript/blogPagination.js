let currentPage = 0;
const pageSize = 4; // 한 페이지에 표시할 블로그 수

function loadBlogs(page) {
    $.ajax({
        url: `/api/blogs?page=${page}&size=${pageSize}&sort=date,desc`,
        method: 'GET',
        cache: false,
        success: function(data) {
            $('#blog-container').empty();
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
                (data.totalPages, data.number);
        },
        error: function() {
            alert('블로그를 불러오는 데 실패했습니다.');
        }
    });
}

function updatePagination(totalPages, currentPage) {
    $('#page-numbers').empty();

    for (let i = 0; i < totalPages; i++) {
        const pageNumber = $('<button></button>').text(i + 1).click(function() {
            currentPage = i;
            loadBlogs(currentPage);
        });
        if (i === currentPage) {
            pageNumber.prop('disabled', true); // 현재 페이지는 비활성화
        }
        $('#page-numbers').append(pageNumber);
    }

    $('#first-button').off('click').on('click', function() {
        currentPage = 0;
        loadBlogs(currentPage);
    });

    $('#last-button').off('click').on('click', function() {
        currentPage = totalPages - 1;
        loadBlogs(currentPage);
    });
}

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
