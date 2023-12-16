const randomIndex = Math.floor(Math.random() * 2) + 1;
const element = document.getElementById(`featured-${randomIndex}`);

if (element) {
	element.style.display = "block";
}