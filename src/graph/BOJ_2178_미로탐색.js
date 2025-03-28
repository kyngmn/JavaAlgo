const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().replace(/\r/g, "").split("\n");

const [N, M] = input.shift().split(" ");

const arr = [];
for (let i = 0; i < N; i++) {
  const row = [];
  for (let j = 0; j < M; j++) {
    row.push(input[i].charAt(j) == "1" ? 1 : 0);
  }
  arr.push(row);
}

let queue = [[0, 0, 1]];
arr[0][0] = 0;

const delta = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];
while (queue.length > 0) {
  const curr = queue.shift();

  for (let i = 0; i < delta.length; i++) {
    const nr = curr[0] + delta[i][0];
    const nc = curr[1] + delta[i][1];

    if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 1) {
      if (nr == N - 1 && nc == M - 1) {
        console.log(curr[2] + 1);
        queue = [];
        break;
      }

      queue.push([nr, nc, curr[2] + 1]);
      arr[nr][nc] = 0;
    }
  }
}
