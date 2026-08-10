using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public int[] solution(string[] genres, int[] plays)
    {
        List<int> answer = new List<int>();

        Dictionary<string, int> genreMap = new Dictionary<string, int>();

        for (int i = 0; i < genres.Length; i++)
        {
            string curGen = genres[i];
            int curCnt = plays[i];

            if (genreMap.ContainsKey(curGen))
                genreMap[curGen] += curCnt;
            else
                genreMap[curGen] = curCnt;
        }

        List<string> genreRank = genreMap.Keys.ToList();

        genreRank.Sort((e1, e2) =>
            genreMap[e2].CompareTo(genreMap[e1])
        );

        foreach (string genre in genreRank)
        {
            List<int> list = new List<int>();

            for (int i = 0; i < genres.Length; i++)
            {
                if (genres[i] == genre)
                {
                    list.Add(i);
                }
            }

            list.Sort((e1, e2) =>
                plays[e2].CompareTo(plays[e1])
            );

            int cnt = 0;

            foreach (int num in list)
            {
                if (cnt >= 2)
                    break;

                answer.Add(num);
                cnt++;
            }
        }

        return answer.ToArray();
    }
}