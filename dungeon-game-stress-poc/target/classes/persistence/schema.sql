-- PostgreSQL schema for Dungeon Game results
CREATE TABLE IF NOT EXISTS dungeon_results (
    id BIGSERIAL PRIMARY KEY,
    dungeon_data TEXT NOT NULL,
    result INTEGER NOT NULL,
    rows INTEGER NOT NULL,
    columns INTEGER NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for better query performance
CREATE INDEX IF NOT EXISTS idx_dungeon_results_result ON dungeon_results(result);
CREATE INDEX IF NOT EXISTS idx_dungeon_results_dimensions ON dungeon_results(rows, columns);
CREATE INDEX IF NOT EXISTS idx_dungeon_results_created_at ON dungeon_results(created_at DESC);