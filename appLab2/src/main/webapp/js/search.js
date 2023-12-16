function find() {
	const x = document.getElementById("mySearch").value.toLowerCase();
	fetch("/Gradle___hummel___Lab02_1_0_SNAPSHOT_war__exploded_/json/name_mappings.json")
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