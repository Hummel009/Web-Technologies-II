function find() {
	const x = document.getElementById("mySearch").value.toLowerCase();
	fetch("/json/name_mappings.json")
		.then((response) => response.json())
		.then((data) => {
			const nameMappings = data;

			let targetPage = "";
			for (const name in nameMappings) {
				if (nameMappings[name].some((alias) => x.includes(alias))) {
					targetPage = `./${name}`;
					break;
				}
			}

			if (targetPage !== "") {
				window.open(targetPage, "_self");
			}
		})
		.catch((error) => {
			console.error("Error reading JSON file:", error);
		});
}

document.getElementById("find")?.addEventListener("click", find);