package util;

import java.util.ArrayList;
import java.util.List;

public class Forms
{
    private List<String> items = new ArrayList<String>();

    public List<String> fillUpModal(String... fields)
    {
        for(String f : fields)
        {
            items.add(f);
        }

        return items;
    }
}
