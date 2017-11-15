package com.scorsi.gameengine.entities

class EntityRenderSorter implements Comparator<Entity> {

    @Override
    int compare(Entity o1, Entity o2) {
        Boolean o1Visible = o1 instanceof Visible
        Boolean o2Visible = o2 instanceof Visible
        if (!o1Visible && !o2Visible)
            return 0
        else if (!o1Visible)
            return 1
        else if (!o2Visible)
            return -1

        // Ignore warnings, already checked above
        if (o1.position.y + o1.size.y < o2.position.y + o2.size.y)
            return -1
        return 1
    }

}
