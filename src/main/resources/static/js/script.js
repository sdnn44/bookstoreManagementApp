import Swiper from 'https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.esm.browser.min.js';

window.onscroll = () => {
  if (window.scrollY > 80) {
    document.querySelector(".header .header-navbar").classList.add("active");
  } else {
    document.querySelector(".header .header-navbar").classList.remove("active");
  }
};

window.onload = () => {
  if (window.scrollY > 80) {
    document.querySelector(".header .header-navbar").classList.add("active");
  } else {
    document.querySelector(".header .header-navbar").classList.remove("active");
  }
};

var swiper = new Swiper(".recommended-slider", {
  loop: false,
  grabCursor: true,
  centeredSlides: true,
  autoplay: {
    delay: 9500,
    disableOnInteraction: false,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
 
  breakpoints: {
    0: {
      slidesPerView: 1,
    },
    400: {
      slidesPerView: 1,
    },
    768: {
      slidesPerView: 3,
    },
    1024: {
      slidesPerView: 4,
    },
  },
  pagination: {
    el: ".swiper-pagination",
  },
  
});

var swiperReviews = new Swiper(".review-slider", {
  grabCursor: true,
  loop: false,
  centeredSlides: true,
  spaceBetween: 20,
  autoplay: {
    delay: 2500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  breakpoints: {
    0: {
      slidesPerView: 1,
    },
    1024: {
      slidesPerView: 1,
    },
    1200: {
      slidesPerView: 1,
    },
  },
});
