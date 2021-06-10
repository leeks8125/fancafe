<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 종이 스타일 -->
<style>
    .paper {
        width: 190px;
        margin-top: 10px;
        padding: 15px 15px 0;
        font-size: 11px;
        background: #FFFFFF;
        box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
    }

    .paper-content {
        margin: 0 -15px;
        margin-top: 10px;
        padding: 10px 15px;
        background: #F2F0F0;

        overflow: hidden;
    }

    .paper-description {
        margin: 10px 0;
    }

    .paper-link {
        display: block;
        float: left;
    }

    .paper-text {
        float: left;
        width: 150px;
        margin-left: 10px;
    }
</style>
<!-- 섹션 -->
<style>
    /* 미디어 쿼리를 지원하지 않는 웹 브라우저 */
    #main-section {
        width: 920px;
        margin: 0 auto;
    }

    /* 3줄 */
    @media (max-width: 919px) {
        #main-section { width: 690px; }
    } 

    /* 4줄 */
    @media (min-width: 920px) and (max-width:1149px) {
        #main-section { width: 920px; }
    } 

    /* 5줄 */
    @media (min-width:1150px) and (max-width:1379px) {
        #main-section { width: 1150px; }
    }

    /* 6줄 */
    @media (min-width:1380px) {
        #main-section { width: 1380px; }
    }
</style>
<!-- 라이트박스 -->
<style>
    #darken-background {
        position: absolute;
        top: 0; left: 0; right: 0;
        height: 100%; 

        display: none;
        background: rgba(0, 0, 0, 0.9);
        z-index: 10000;
        overflow-y: scroll;
    }

    #lightbox {
        width: 700px;
        margin: 20px auto; padding: 15px;

        border: 1px solid #333333;
        border-radius: 5px;
        background: white;
        box-shadow: 0 5px 5px rgba(34, 25, 25, 0.4);

        text-align: center;
    }

    .user-information {  overflow: hidden;  text-align: left; }
    .user-information-image { float: left; width: 70px; }
    .user-information-text { float: right; width: 620px;  }
    .lightbox-splitter { margin: 10px 0; }
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="jquery.masonry.min.js"></script>
<script src="jquery.imagesloaded.min.js"></script>
<script>
        // 풀다운 메뉴
        $(document).ready(function () {
            // 풀다운 메뉴
            $('.outer-menu').hover(function () {
                $(this).find('.inner-menu').css('display', 'block');
            }, function () {
                $(this).find('.inner-menu').css('display', 'none');
            });
        });

        // 페이지
        $(document).ready(function () {
            // 이미지 로드 확인
            $('#main-section').imagesLoaded(function () {
                // jQuery Masonry 플러그인 적용
                $('#main-section').masonry({
                    itemSelector: '.paper',
                    columnWidth: 230,
                    isAnimated: true
                });
            });
        });
          
        
        // 라이트 박스
        $(document).ready(function () {
            function showLightBox() {
                // 라이트박스를 보이게 합니다.
                $('#darken-background').show();
                $('#darken-background').css('top', $(window).scrollTop());
                // 스크롤을 못하게 합니다.
                $('body').css('overflow', 'hidden');
            }

            function hideLightBox() {
                // 라이트박스를 안 보이게 합니다.
                $('#darken-background').hide();

                // 스크롤을 하게 합니다.
                $('body').css('overflow', '');
            }

            // 라이트박스 제거 이벤트
            $('#darken-background').click(function () {
                hideLightBox();
            });

              // 클릭 이벤트 연결
            $('.paper').click(function () {
                showLightBox();
            });

            // 라이트박스 제거 이벤트 보조
            $('#lightbox').click(function (event) {
                event.stopPropagation()
            });
        });
    </script>

<!-- header 파일 불러오기 -->
<%@ include file="/common/header.jsp" %>
    <!-- 본문 영역 --> 
    <section id="main-section"> 
         
        <div class="paper"> 
            <div class="paper-holder"> 
                <a><img width="190" src="http://placekitten.com/190/328" /></a> 
            </div> 
            <p class="paper-description">Lorem ipsum dolor sit amet</p> 
            <div class="paper-content"> 
                <a class="paper-link" href="#"><img src="http://placekitten.com/30/30" /></a> 
                <p class="paper-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sem mi, egestas a facilisis eget, egestas ut magna.</p> 
            </div> 
        </div>         
    </section> 
	
<!-- footer 파일 불러오기 -->
<%@ include file="/common/footer.jsp" %>