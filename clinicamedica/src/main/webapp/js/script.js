let currentSlideIndex = 0;
const totalSlides = document.querySelectorAll('.carousel-container-1, .carousel-container-2').length;

function nextSlide() {
    currentSlideIndex++;
    if (currentSlideIndex >= totalSlides) {
        currentSlideIndex = 0;
    }
    updateCarousel();
}

function prevSlide() {
    currentSlideIndex--;
    if (currentSlideIndex < 0) {
        currentSlideIndex = totalSlides - 1;
    }
    updateCarousel();
}

function updateCarousel() {
    const carouselContainers = document.querySelectorAll('.carousel-container-1, .carousel-container-2');
    carouselContainers.forEach((container, index) => {
        if (index === currentSlideIndex) {
            container.style.display = 'flex';
        } else {
            container.style.display = 'none';
        }
    });
}
