if (typeof Storage !== "undefined") {
    function toLanguage(lang) {
        if (localStorage.getItem("lang") !== lang) {
            localStorage.setItem("lang", lang);
            loadTranslations(lang);
        }
    }

    function loadTranslations(lang) {
        fetch(`/Gradle___hummel___Lab02_1_0_SNAPSHOT_war__exploded_/json/translations_${lang}.json`)
            .then((response) => response.json())
            .then((translations) => {
                for (const key in translations) {
                    const elements = document.querySelectorAll(`[id="${key}"]`);
                    elements.forEach((element) => {
                        element.innerHTML = translations[key] || "";
                    });
                }
            });
    }

    document.getElementById("lang-en")?.addEventListener("click", () => toLanguage("eng"));
    document.getElementById("lang-be")?.addEventListener("click", () => toLanguage("bel"));

    const storedLang = localStorage.getItem("lang") || "eng";
    loadTranslations(storedLang);
}