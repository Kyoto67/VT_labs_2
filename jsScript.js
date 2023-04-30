const diffs = project.getProperty("differences").split("\n");
const params = project.getProperty("params").split("\n");
for (let i=0; i<params.length; i++) {
    for (let j=0; j<diffs.length; j++) {
        if (params[i] === diffs[j]) {
            var flag = true;
            break;
        }
    }
    if (flag) {
        break;
    }
}