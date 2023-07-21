const baseURL = "http://localhost:8080"

$(document).ready(function () {
    let token = localStorage.getItem("token")

    // getAllBanner -------------------------------------------------------------------------------------
    $.ajax({
        url: baseURL + "/banner",
        method: "get",
        headers: {
            Authorization: "Bearer " + token,
        }
    }).done(function (result) {
        let data = result.data
        let banner = ''

        for(let index =0;index<data.length;index++){
            let item = data[index]
            banner+=`
            <div class="col-md-6 col-xl-4 p-b-30 m-lr-auto">
        			<div class="block1 wrap-pic-w">
        				<img src="images/${item.image}" style="height:max-content;" alt="IMG-BANNER">
        				<a href="product.html"
        					class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
        					<div class="block1-txt-child1 flex-col-l">
        						<span class="block1-name ltext-102 trans-04 p-b-8">
                                    ${item.name}
        						</span>
        						<span class="block1-info stext-102 trans-04">
                                    ${item.content}
        						</span>
        					</div>
        					<div class="block1-txt-child2 p-b-4 trans-05">
        						<div class="block1-link stext-101 cl0 trans-09">
        							Shop Now
        						</div>
        					</div>
        				</a>
        			</div>
        		</div>
            `
        }
        document.getElementById("banner-list").innerHTML=banner

    })
    // getAllBanner -------------------------------------------------------------------------------------


    // Lấy danh sách category ---------------------------------------------------------------------------
    $.ajax({
        url: baseURL + "/category",
        method: "get",
        headers: {
            Authorization: "Bearer " + token,
        }
    }).done(function (result) {

        let categoryContent = `
                <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1" data-filter="*" onclick="getAllProduct()">
                    All Products
                </button>`
        let data = result.data

        for (let index = 0; index < data.length; index++) {
            let item = data[index]
            let contentBtn = `
                <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".${item.name.toLowerCase()}" onclick="changeCategory(${item.id},'${item.name}')">
                    ${item.name}
                </button>`

            categoryContent += contentBtn
        }
        document.getElementById("category").innerHTML = categoryContent

    })
    // Lấy danh sách category ---------------------------------------------------------------------------


    // Load product item ---------------------------------------------------------------------------------

    let changeCategory = (id, name) => {
        let productContent = ""

        $.ajax({
            url: baseURL + "/product" + "/category/" + id,
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {

            let data = result.data

            for (let index = 0; index < data.length; index++) {
                let item = data[index]
                let productItem = `
                    <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item animate__animated animate__zoomIn ${name.toLowerCase()}">
                        <div class="block2">
                            <div class="block2-pic hov-img0">
                                <img src="images/${item.image}" alt="IMG-PRODUCT" style="height: 390px;">
                                <a class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1 pointer" onclick="modalProductDetail(${item.id})" onclick="productDetail(${item.id})">
                                    Quick View
                                </a>
                            </div>
                            <div class="block2-txt flex-w flex-t p-t-14">
                                <div class="block2-txt-child1 flex-col-l ">
                                    <a href="product-detail.html" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6 text-truncate w-75">
                                        ${item.name}
                                    </a>
                                    <span class="stext-105 cl3">
                                        $${item.price}
                                    </span>
                                </div>
                                <div class="block2-txt-child2 flex-r p-t-3">
                                    <a class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                        <img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png"
                                            alt="ICON">
                                        <img class="icon-heart2 dis-block trans-04 ab-t-l"
                                            src="images/icons/icon-heart-02.png" alt="ICON">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>`
                productContent += productItem
            }
            document.getElementById("product-list").innerHTML = productContent

        })
    }
    window.changeCategory = changeCategory
    // Load product item ---------------------------------------------------------------------------------


    // getAllProduct --------------------------------------------------------------------------------------
    let getAllProduct = () => {
        let productContent = ""

        $.ajax({
            url: baseURL + "/product/category/all",
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data

            for (let index = 0; index < data.length; index++) {
                let item = data[index]

                let productItem = `
                    <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item animate__animated animate__zoomIn">
                        <div class="block2">
                            <div class="block2-pic hov-img0">
                                <img src="images/${item.image}" alt="IMG-PRODUCT" style="height: 390px;">
                                <a class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1 pointer" onclick="modalProductDetail(${item.id})">
                                    Quick View
                                </a>
                            </div>
                            <div class="block2-txt flex-w flex-t p-t-14">
                                <div class="block2-txt-child1 flex-col-l ">
                                    <a href="product-detail.html" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6 text-truncate w-75">
                                        ${item.name}
                                    </a>
                                    <span class="stext-105 cl3">
                                        $${item.price}
                                    </span>
                                </div>
                                <div class="block2-txt-child2 flex-r p-t-3">
                                    <a class="btn-addwish-b2 dis-block pos-relative js-addwish-b2 pointer" onclick="handleFavorite()">
                                        <img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png"
                                            alt="ICON">
                                        <img class="icon-heart2 dis-block trans-04 ab-t-l"
                                            src="images/icons/icon-heart-02.png" alt="ICON">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>`
                productContent += productItem

            }
            document.getElementById("product-list").innerHTML = productContent
        })
    }
    window.onload = getAllProduct
    window.getAllProduct = getAllProduct
    // getAllProduct --------------------------------------------------------------------------------------


    // getProductById ---------------------------------------------------------------------------------
    let productDetail = (id) => {
        $.ajax({
            url: baseURL + "/product/" + id,
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data
            let imageDetail = ''
            let imageInformation = `
                <h4 class="mtext-105 cl2 js-name-detail p-b-14">
					${data.name}
				</h4>
				<span class="mtext-106 cl2">
					$${data.price}
				</span>
				<p class="stext-102 cl3 p-t-23">
					${data.description}
				</p>
            `

            // tách chuỗi image thành mảng đối tượng
            let imageDetailArr = data.imageDetail.split(",")

            imageDetailArr.map((element) => {
                imageDetail += `
                    <div class="item-slick3 my-3" data-thumb="images/${element}">
                        <div class="wrap-pic-w pos-relative">
                            <img src="images/${element}" alt="IMG-PRODUCT">
                            <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
                                href="images/${element}">
                                <i class="fa fa-expand"></i>
                            </a>
                        </div>
                    </div>`
                return imageDetail
            })
            document.getElementById("image-detail").innerHTML = imageDetail
            document.getElementById("product-information").innerHTML = imageInformation

        })
    }
    window.productDetail = productDetail
    // getProductById ---------------------------------------------------------------------------------


    // getAllSize -------------------------------------------------------------------------------------

    let getAllSize = () => {
        $.ajax({
            url: baseURL + "/size",
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data
            let productSize = `<option>Choose an option</option>`


            for (let index = 0; index < data.length; index++) {
                let item = data[index]

                productSize += `<option>Size ${item.name}</option>`

            }
            document.getElementById("product-size").innerHTML = productSize
        })
    }
    window.getAllSize = getAllSize

    // getAllSize -------------------------------------------------------------------------------------


    // getAllSize -------------------------------------------------------------------------------------

    let getAllColor = () => {
        $.ajax({
            url: baseURL + "/color",
            method: "get",
            headers: {
                Authorization: "Bearer " + token,
            }
        }).done(function (result) {
            let data = result.data
            let productColor = `<option>Choose an option</option>`

            for (let index = 0; index < data.length; index++) {
                let item = data[index]

                productColor += `<option>${item.name}</option>`

            }
            document.getElementById("product-color").innerHTML = productColor
        })
    }
    window.getAllColor = getAllColor

    // getAllSize -------------------------------------------------------------------------------------


    // show modal product detail ----------------------------------------------------------------------
    let modalProductDetail = (id) => {
        $('.js-modal1').addClass('show-modal1');

        productDetail(id)
        getAllSize()
        getAllColor()



    }
    window.modalProductDetail = modalProductDetail

    // handleFavorite ---------------------------------------------------------------------------------
    let handleFavorite = () => {

        $('.js-addwish-b2').each(function () {
            var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");

                $(this).addClass('js-addedwish-b2');
                $(this).off('click');
            });
        });
    }
    window.handleFavorite = handleFavorite

    // test ----------------------------------------------------------------------------------------------------


    // $('#image-detail').slick({
    //     infinite: true,
    //     slidesToShow: 3,
    //     slidesToScroll: 3
    //   });

    // $('.wrap-slick3').each(function () {
    //     $(this).find('.slick3').slick({
    //         slidesToShow: 1,
    //         slidesToScroll: 1,
    //         fade: true,
    //         infinite: true,
    //         autoplay: true,
    //         autoplaySpeed: 3000,

    //         arrows: true,
    //         appendArrows: $(this).find('.wrap-slick3-arrows'),
    //         prevArrow: '<button class="arrow-slick3 prev-slick3"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
    //         nextArrow: '<button class="arrow-slick3 next-slick3"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',

    //         dots: true,
    //         appendDots: $(this).find('.wrap-slick3-dots'),
    //         dotsClass: 'slick3-dots',
    //         customPaging: function (slick, index) {
    //             var portrait = $(slick.$slides[index]).data('thumb');
    //             return '<img src=" ' + portrait + ' "/><div class="slick3-dot-overlay"></div>';
    //         },
    //     });

    // });

    // $('.gallery-lb').each(function () { // the containers for all your galleries
    //     $(this).magnificPopup({
    //         delegate: 'a', // the selector for gallery item
    //         type: 'image',
    //         gallery: {
    //             enabled: true
    //         },
    //         mainClass: 'mfp-fade'
    //     });
    // });

    // test ----------------------------------------------------------------------------------------------------

})

