class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> langMap = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            langMap.put(i + 1, new HashSet<>());
            for (int lang : languages[i]) {
                langMap.get(i + 1).add(lang);
            }
        }

        Set<Integer> needToTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            Set<Integer> langsU = langMap.get(u);
            Set<Integer> langsV = langMap.get(v);

            boolean canCommunicate = false;
            for (int l : langsU) {
                if (langsV.contains(l)) {
                    canCommunicate = true;
                    break;
                }
            }

            if (!canCommunicate) {
                needToTeach.add(u);
                needToTeach.add(v);
            }
        }

        if (needToTeach.isEmpty()) return 0;

        int[] count = new int[n + 1];
        for (int person : needToTeach) {
            for (int lang : langMap.get(person)) {
                count[lang]++;
            }
        }

        int maxCommon = 0;
        for (int i = 1; i <= n; i++) {
            maxCommon = Math.max(maxCommon, count[i]);
        }

        return needToTeach.size() - maxCommon;
    }
}
