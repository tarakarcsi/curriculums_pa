let topicsTableEl;
let topicsTableBodyEl;

function onTopicsLoad() {
    topicsTableEl = document.getElementById('topics-table');
    topicsTableBodyEl = topicsTableEl.querySelector('topics-tbody');

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onTopicsResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('GET', 'topics');
    xhr.send();
}

function onTopicsResponse() {
    if(this.status === OK) {
        const text = JSON.parse(this.responseText);
        console.log(text);
        displayTopics(text);
    }else{
        console.log('??');
    }
}

function displayTopics(topics){
    topicsTableEl = document.getElementById('topics-table');
    topicsTableBodyEl = topicsTableEl.querySelector('tbody');
    removeAllChildren(topicsTableBodyEl);

    for(let i = 0; i<topics.length; i++) {
        const topic = topics[i];
        const topicTitleEl = document.createElement('td');

        topicTitleEl.textContent = topic.title;
        topicTitleEl.setAttribute('id', topic.id);

        const trEl = document.createElement('tr');
        trEl.appendChild(topicTitleEl);

        topicsTableBodyEl.appendChild(trEl);
    }
}