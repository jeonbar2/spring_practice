|기능|Method|URL|Return|
|:---|:---:|:---:|:---:|
|전체 게시글목록 조회|GET|/api/posts|List<Post>|
|게시글 작성|POST|/api/post|Post|
|게시글 조회|GET|/api/post/{id}|Post|
|게시글 수정|PUT|/api/post/{id}|Long|
|게시글 삭제|DELETE|/api/post/{id}|Long|
|댓글 작성|POST|/api/comment/{post_id}|Comment|
|댓글 조회|GET|/api/comments/{post_id}|List<Comment>|
|댓글 수정|PUT|/api/comments/{comment_id}|Long|
|댓글 삭제|DELETE|/api/comments/{comment_id}|Long|
