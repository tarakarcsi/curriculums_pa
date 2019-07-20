let topicsTableBodyEl;

function displayTopics(topics){
    topicsTableBodyEl = document.getElementById('topics-tbody');

    for(let i = 0; i<topics.length; i++) {
        const topic = topics[i];
        const topicTitleEl = document.createElement('td');

        topicTitleEl.textContent = topic.title;
        topicTitleEl.setAttribute('id', topic.title);

        const trEl = document.createElement('tr');
        trEl.appendChild(topicTitleEl);

        topicsTableBodyEl.appendChild(trEl);
    }
}

function onTopicsResponse() {
    if(this.status === OK) {
        const text = JSON.parse(this.responseText);
        displayTopics(text);
    }
}

function onTopicsLoad() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onTopicsResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('GET', 'topics');
    xhr.send();
    showContents(['topics', 'navbar']);

}